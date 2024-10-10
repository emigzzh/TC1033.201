#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>

#include "DummyMaker.h"
#include "FightingPokemon.h"

using namespace std;

class MainClass {
    private:
        vector<DummyMaker> pokemonList;

    public:
        vector<DummyMaker> getPokemonList() {
            return pokemonList;
        }

        void addItem(DummyMaker& item) {
            pokemonList.push_back(item);
        }
};

int DataLoader(MainClass& vectorList){
    ifstream myFile;
    myFile.open("PokeData.csv");

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

        double height = stod(heightStr);
        double weight = stod(weightStr);
        int hp = stoi(hpStr);
        int defense = stoi(defenseStr);
        int speed = stoi(speedStr);

        DummyMaker dummy(name, generation, status, type1, type2, height, weight, hp, defense, speed);
        vectorList.addItem(dummy);
    }

    myFile.close();
    return 0;
}

int main(){
    MainClass list;
    DataLoader(list);

    bool flag = true;
    int option;

    cout << "Bienvenido a la Pokedex! Ingrese el número de alguna de las siguientes opciones para realizar acciones:" << endl;

    while(flag) {
        cout << "\n <1> Mostrar las estadísticas de algún Pokémon" << endl;
        cout << " <2> Comparar los tipos de dos Pokemones" << endl;
        cout << " <3> Ingresar un nuevo Pokemón a la Pokedex" << endl;
        cin >> option;

        switch(option) {
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
                                cin >> level;
                                cin >> evs;
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
                                cin >> level;
                                cin >> evs;
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
                cout << "Su Pokemon tiene los siguientes dos tipos, seleccione cuál usará para atacar (si solo hay uno, se seleccionará ese automáticamente)" << endl;
                cout << " <1>" << attacker.getType1() << endl;
                cout << " <2>" << attacker.getType2() << endl;
                cin >> attackerTypeOption;

                if(attackerTypeOption == 2 && !(attacker.getType2().empty())) {
                    attackerType = attacker.getType2();
                } else {
                    attackerType = attacker.getType1();
                }

                cout << "\n\n>> Comienza la pelea entre " << attacker.getName() << " y " << defender.getName() << endl;
                bool endFight = false;

                while(!endFight) {
                    string defenderType;

                    if(rand()%2 == 0) { defenderType = defender.getType1(); }
                    else { defenderType = defender.getType2(); }

                    cout << "\n" << attacker.getName() << " ataca a " << defender.getName() << endl;
                    defender.damagePokemon(attackerType, attacker);

                    if(defender.getHp() <= 0 && !endFight) {
                        cout << "\n>> " << attacker.getName() << " es el ganador! Con " << attacker.getHp() << " HP restante" << endl;
                        endFight = true;
                    }

                    cout << "\n" << defender.getName() << " ataca a " << attacker.getName() << endl;
                    attacker.damagePokemon(defenderType, defender);

                    if(attacker.getHp() <= 0 && !endFight) {
                        cout << "\n>> " << defender.getName() << " es el ganador! Con " << defender.getHp() << " HP restante" << endl;
                        endFight = true;
                    }
                }
                
                break;
            }
            case 3: {

                break;
            }
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