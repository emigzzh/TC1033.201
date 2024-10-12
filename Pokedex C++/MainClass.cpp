#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <algorithm>

// Clase de objetos del proyecto que se utilizan en este código
#include "DummyMaker.h"
#include "FightingPokemon.h"

using namespace std;

/*  Modelación del objeto MainClass
    El propósito de este objeto es tener runa relación de agregación con los objetos DummyMaker.

    Todo MainClass -tiene un- DummyMaker. (Contiene) 

    Un objeto MainClass tiene como único atributo un vector<DummyMaker> cuyo único propósito
    es almacenar los DummyMaker creados en un vector dinámico para ser accesados posteriormente.
*/

class MainClass {
    private:
        vector<DummyMaker> pokemonList;

    public:
        vector<DummyMaker> getPokemonList() {
            return pokemonList;
        }

        // Permite el comportamiento de añadir un elemento al final del vector<DummyMaker>.
        void addItem(DummyMaker& item) {
            pokemonList.push_back(item);
        }
};

/*  DataLoader() tiene la función de cargar la información del csv 'PokeData' y crear objetos
    DummyMaker con la información de cada renglón del archivo.

    Este tiene la sig. estructura:
    name,generation,status,type_1,type_2,height,weight,hp,defense,speed

    Tiene como parámetro el objeto MainClass con el modificador & para que sea modificado 
    dentro de este método y los objetos DummyMaker se van almacenando en este.
*/
int DataLoader(MainClass& vectorList) {
    ifstream myFile;
    myFile.open("PokeData.csv");

    // Si falla al accesar al archivo, retorna 1 e imprime un mensaje de error.
    if (!myFile.is_open()) {
        cout << "Error: No se pudo ingresar al archivo." << endl;
        return 1; 
    }

    string line;
    getline(myFile, line);

    while(getline(myFile,line)){
        stringstream ss(line);
        string name, generation, status, type1, type2, heightStr, weightStr, hpStr, defenseStr, speedStr;

        getline(ss, name, ',');
        getline(ss, generation, ',');
        getline(ss, status, ',');
        getline(ss, type1, ',');
        getline(ss, type2, ',');
        getline(ss, heightStr, ',');
        getline(ss, weightStr, ',');
        getline(ss, hpStr, ',');
        getline(ss, defenseStr, ',');
        getline(ss, speedStr, '\n');

        /*  Parse de string a double/int, la información recuperada del csv estrictamente 
            son cadenas de carácteres.
         */
        double height = stod(heightStr);
        double weight = stod(weightStr);
        int hp = stoi(hpStr);
        int defense = stoi(defenseStr);
        int speed = stoi(speedStr);

        DummyMaker dummy(name, generation, status, type1, type2, height, weight, hp, defense, speed);
        vectorList.addItem(dummy);
    }

    // Para evitar posibles problemas, se cierra el archivo
    myFile.close();
    return 0;
}

/*  Método usado en el código main() para buscar un string pasado como parámetro
    en el arreglo de strings esTipoValido[]. Retorna un booleano true si encuentra el valor,
    y false si no.
*/
bool esTipoValido(string tipo) {
    string tiposValidos[] = {"Normal", "Fire", "Water", "Electric", "Grass", 
                             "Ice", "Fighting", "Poison", "Ground", "Flying", 
                             "Psychic", "Bug", "Rock", "Ghost", "Dragon", 
                             "Dark", "Steel", "Fairy"};

    return find(begin(tiposValidos), end(tiposValidos), tipo) != end(tiposValidos);
}

int main() {
    // Crea el objeto MainClass con el constructor por default de la clase
    MainClass list;
    DataLoader(list);

    bool flag = true;
    int option;

    cout << "Bienvenido a la Pokedex! Ingrese el número de alguna de las siguientes opciones para realizar acciones:" << endl;

    /*  Al accesar a la Pokedex, la consola imprime tres opciones que se pueden realizar. Estas se pueden hacer
        ingresando el número de la opción <n> antepuesto. Si se escribe un número distinto a los proporcionados,
        imprime un error de opción no disponible y regresa al usuario a esta parte de nuevo.

        El parámetro flag del ciclo while se usa para mantener al usuario dentro de la Pokedex y evitar que
        tenga que lanzar el programa cada vez que quiera volver a realizar una acción en la Pokedex. Si el usuario
        al final ingresa que quiere abandonar la Pokedex, flag se vuelve false.
    */
    while(flag) {
        cout << "\n <1> Mostrar las estadísticas de algún Pokémon" << endl;
        cout << " <2> Simular un combate entre dos Pokemones" << endl;
        cout << " <3> Ingresar un nuevo Pokemón a la Pokedex" << endl;
        cin >> option;

        switch(option) {

            /*  Esta opción <1> modela la búsqueda de un Pokemon (objeto DummyMaker) en la Pokedex. 
                Los pokemones están almacenados en el objeto MainClass list. Este caso permite que el usuario
                ingrese el nombre pokemon y se almacene en la variable key. 

                Posteriormente realiza la búsqueda usando list.getPokemonList()[i].getName(). Si falla, imprime
                un mensaje de error y permite al usuario ingresar un nuevo nombre o abandonar y realizar orta opción.
                Si la búsqueda es exitosa, imprime toda la información del Pokemon invocando printPokemon().
            */
            case 1: {
                bool flagCase1 = true;
                while(flagCase1) {
                    cout << "\nIngrese el nombre de un Pokémon válido (case sensitive):" << endl;

                    int i = 0;
                    string key;
                    cin >> key;

                    while (i < list.getPokemonList().size() && flagCase1) {
                        if (list.getPokemonList()[i].getName() == key) {
                            list.getPokemonList()[i].printPokemon();
                            flagCase1 = false;
                        }

                        i++;
                    }

                    if (flagCase1) {
                        cout << ">> Error: No se pudo encontrar el Pokémon" << endl;
                        cout << "Ingrese 0 si desea abandonar (de lo contrario, cualquier otro valor)" << endl;

                        int key2;
                        cin >> key2;

                        if(key2 == 0) { flagCase1 = false; }
                    }
                }

                break;
            }

            /*  La opción <2> simula un combate primitivo entre dos Pokemones utilizando las clases DummyMaker y FightingPokemon.
                Pide al usuario ingresar dos Pokemones y como en la opción anterior y adicionalmente ingresar 3 valores
                adicionales que corresponden a los atributos faltantes (nivel, evs, ivs) para completar FightingPokemon.

                Al tener ambos Pokemones listos, pide al usuario que ingrese con que tipo de ataque atacará al otro Pokemon.
                Por ejemplo, si el usuario ingresa su Pokemon como "Lucario" (tipo Fighting y Steel), este puede decidir
                si ataca al otro Pokemon con Fighting o Steel.

                Al comenzar la pelea, se imprimen los atributos de cada FightingPokemon con el método sobrecargado printPokemon()
                y comienzan a reducirse sus puntos de vida con el método damagePokemon) de FightingPokemon.

                El primer Pokemon en llegar a 0 HP, pierde el combate.
            */
            case 2: {
                FightingPokemon attacker;
                FightingPokemon defender;

                cout << "\nEscriba el nombre del Pokémon con el que atacará" << endl;

                bool flagCase2 = true;
                while(flagCase2) {

                    int i = 0;
                    string key;
                    cin >> key;

                    while (i < list.getPokemonList().size() && flagCase2) {
                        if (list.getPokemonList()[i].getName() == key) {
                            DummyMaker temp = list.getPokemonList()[i];

                            cout << "\nAsignele un nivel (level), EVs y IVs a su Pokémon (en valores enteros positivos)" << endl;
                            int level, evs, ivs = 0;
                            bool flagCase2_1 = true;

                            while(flagCase2_1){
                                cout << "Inserte el nivel: ";
                                cin >> level;
                                cout << "Inserte los puntos EVs (1 -> 540): ";
                                cin >> evs;
                                cout << "Inserte los puntos IVs (1 -> 31): ";
                                cin >> ivs;

                                if(level > 0 && evs > 0 && ivs > 0){
                                    flagCase2_1 = false;
                                    attacker = FightingPokemon(temp, level, evs, ivs);
                                } else {
                                    cout << "Valores inválidos\n" << endl;
                                }
                            }

                            flagCase2 = false;
                        }

                        i++;
                    }

                    if (flagCase2) {
                        cout << ">> Error: No se pudo encontrar el Pokémon" << endl;
                        cout << "Intente de nuevo" << endl;
                    }
                }

                cout << "\nEscriba el nombre del Pokémon al que atacará" << endl;
                flagCase2 = true;

                while(flagCase2) {

                    int i = 0;
                    string key;
                    cin >> key;

                    while (i < list.getPokemonList().size() && flagCase2) {
                        if (list.getPokemonList()[i].getName() == key) {
                            DummyMaker temp = list.getPokemonList()[i];

                            cout << "\nAsignele un nivel (level), EVs y IVs al Pokémon (en valores enteros positivos)" << endl;
                            int level, evs, ivs = 0;
                            bool flagCase2_1 = true;

                            while(flagCase2_1){
                                cout << "Inserte el nivel: ";
                                cin >> level;
                                cout << "Inserte los puntos EVs (1 -> 540): ";
                                cin >> evs;
                                cout << "Inserte los puntos IVs (1 -> 31): ";
                                cin >> ivs;

                                if(level > 0 && evs > 0 && ivs > 0){
                                    flagCase2_1 = false;
                                    defender = FightingPokemon(temp, level, evs, ivs);
                                } else {
                                    cout << "Valores inválidos\n" << endl;
                                }
                            }

                            flagCase2 = false;
                        }

                        i++;
                    }

                    if (flagCase2) {
                        cout << ">> Error: No se pudo encontrar el Pokémon" << endl;
                        cout << "Intente de nuevo" << endl;
                    }
                }

                int attackerTypeOption;
                string attackerType;
                cout << "\nSu Pokemon tiene los siguientes dos tipos, seleccione cuál usará para atacar (si solo hay uno, se seleccionará ese automáticamente)" << endl;
                cout << " <1>" << attacker.getType1() << endl;
                cout << " <2>" << attacker.getType2() << endl;
                cin >> attackerTypeOption;

                if(attackerTypeOption == 2 && attacker.getType2() != "NONE") {
                    attackerType = attacker.getType2();
                } else {
                    attackerType = attacker.getType1();
                }

                cout << "\n\n>> Comienza la pelea entre " << attacker.getName() << " y " << defender.getName() << endl;
                attacker.printPokemon();
                defender.printPokemon();

                while(true) {
                    string defenderType;

                    if(rand()%2 == 0 || defender.getType2() == "NONE") { defenderType = defender.getType1(); }
                    else { defenderType = defender.getType2(); }

                    cout << "\n" << attacker.getName() << " ataca a " << defender.getName() << " con un ataque tipo <" << attackerType << ">" << endl;
                    defender.damagePokemon(attackerType, attacker);

                    if(defender.getHp() <= 0) {
                        cout << "\n>> " << attacker.getName() << " es el ganador! Con " << attacker.getHp() << " HP restante" << endl;
                        break;
                    }

                    cout << "\n" << defender.getName() << " ataca a " << attacker.getName() << " con un ataque tipo <" << defenderType << ">" << endl;
                    attacker.damagePokemon(defenderType, defender);

                    if(attacker.getHp() <= 0) {
                        cout << "\n>> " << defender.getName() << " es el ganador! Con " << defender.getHp() << " HP restante" << endl;
                        break;
                    }
                }
                
                break;
            }
            
            /*  La última opcion <3> permite que el usuario ingresar un nuevo Pokemon, pidiendo valores para cada atributo de este
                usando la clase DummyMaker. Valida que los valores sean correctos, y dentro de los valores permitidos.

                Por ejemplo, los valores numéricos se espera que sean númericos forzosamente y no cadenas de carácteres, y los
                tipos del Pokemon se encuentran limitados por un pool de 18 opciones. El método esTipoValido() sirve precisamente
                para verificar que el tipo ingresado exista y puedo usarse en otras partes del código, como combates.

                El Pokemon creado no se almacena en el archivoCSV para posterior uso después de terminar el programa, sino en el
                objeto MainClass, por lo que es volátil y no persistente.
            */
            case 3: {
                cout << "\nInserte los siguientes parámetros para crear un nuevo Pokemon" << endl;
                string name, generation, status, type1, type2;
                double height, weight;
                int hp, defense, speed;

                cout << "Nombre: " << endl;
                cin >> name;

                cout << "\nGeneración (Inserte un número): " << endl;
                cin >> generation;

                cout << "\nRareza: " << endl;
                cin >> status;

                bool validInput = false;
                while (!validInput) {
                    cout << "\nTipo1 del Pokemon: " << endl;
                    cin >> type1;

                    if (esTipoValido(type1)) {
                        validInput = true;
                    } else {
                        cout << "> Error: Ingrese un tipo válido para Tipo1" << endl;
                    }
                }

                validInput = false;
                cout << "\nTipo2 del Pokemon (Opcional, puede dejarlo vacío si inserta 0): " << endl;
                cin >> type2;

                if (type2 != "0") {
                    while (!validInput) {
                        if (esTipoValido(type2)) {
                            validInput = true;
                        } else {
                            cout << "> Error: Ingrese un tipo válido para Tipo2, o inserte un 0 si no desea asignar un Tipo2" << endl;
                            cin >> type2;
                            if (type2 == "0") {
                                type2 = "NONE";
                                validInput = true;
                            }
                        }
                    }
                } else {
                    type2 = "NONE";
                }

                validInput = false;
                while (!validInput) {
                    cout << "\nAltura (en m, sin insertar la unidad): " << endl;
                    cin >> height;
                    if (cin.fail() || height <= 0) { 
                        cout << "> Error: Ingrese un valor numérico válido para la altura.\n" << endl;
                        cin.clear();
                        cin.ignore(1000, '\n');
                    } else {
                        validInput = true;
                    }
                }

                validInput = false;
                while (!validInput) {
                    cout << "\nPeso (en kg, sin insertar la unidad): " << endl;
                    cin >> weight;
                    if (cin.fail() || weight <= 0) {
                        cout << "> Error: Ingrese un valor numérico válido para el peso.\n" << endl;
                        cin.clear();
                        cin.ignore(1000, '\n');
                    } else {
                        validInput = true;
                    }
                }

                validInput = false;
                while (!validInput) {
                    cout << "\nHitPoints (HP): " << endl;
                    cin >> hp;
                    if (cin.fail() || hp <= 0) {
                        cout << "> Error: Ingrese un valor numérico válido para los HP.\n" << endl;
                        cin.clear();
                        cin.ignore(1000, '\n');
                    } else {
                        validInput = true;
                    }
                }

                validInput = false;
                while (!validInput) {
                    cout << "\nPuntos de defensa: " << endl;
                    cin >> defense;
                    if (cin.fail() || defense < 0) {
                        cout << "> Error: Ingrese un valor numérico válido para la defensa.\n" << endl;
                        cin.clear();
                        cin.ignore(1000, '\n');
                    } else {
                        validInput = true;
                    }
                }

                validInput = false;
                while (!validInput) {
                    cout << "\nPuntos de velocidad: " << endl;
                    cin >> speed;
                    if (cin.fail() || speed < 0) {
                        cout << "> Error: Ingrese un valor numérico válido para la velocidad.\n" << endl;
                        cin.clear();
                        cin.ignore(1000, '\n');
                    } else {
                        validInput = true;
                    }
                }

                DummyMaker dummy(name, generation, status, type1, type2, height, weight, hp, defense, speed);
                list.addItem(dummy);

                dummy.printPokemon();
                break;
            }
            
            /*  En caso de que se ingrese otro número, se direcciona el usuario al caso default.
            */
            default: {
                cout << option << " no es una opción válida" << endl;
                break;
            }
        }

        cout << "\n¿Desea continuar con alguna otra opción de la Pokedex? (Ingrese el número) \n <1> Sí \n <2> No" << endl;
        bool endFlag = true;
        int key;

        cin >> key;

        while(endFlag) {
            if (key == 1) { endFlag = false; }
            else if (key == 2) { endFlag = false; flag = false; }
            else {
                cout << "Valor no es válido. Ingrese uno nuevamente" << endl;
                cin >> key;
            }
        }
    }

    return 0;
}
