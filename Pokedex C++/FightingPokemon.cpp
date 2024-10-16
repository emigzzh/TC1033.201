#include "FightingPokemon.h"
#include "DummyMaker.h"

#include <cmath>

using namespace std;

/*  Estos dos arreglos se usan para el cálculo de daño con el método damagePokemon()
*/
string types[18] = {
        "Normal", "Fighting", "Flying", "Poison", "Ground", "Rock", "Bug", "Ghost", 
        "Steel", "Fire", "Water", "Grass", "Electric", "Psychic", "Ice", "Dragon", "Dark", "Fairy"
    };

double typeEffectiveness[18][18] = {
        {1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},  // Normal
        {1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 0.5, 2.0},  // Fighting
        {1.0, 0.5, 1.0, 1.0, 0.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 0.5, 2.0, 1.0, 2.0, 1.0, 1.0, 1.0},  // Flying
        {1.0, 0.5, 1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5},  // Poison
        {1.0, 1.0, 1.0, 0.5, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 0.0, 1.0, 2.0, 1.0, 1.0, 1.0},  // Ground
        {0.5, 2.0, 0.5, 0.5, 2.0, 1.0, 1.0, 1.0, 2.0, 0.5, 2.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},  // Rock
        {1.0, 0.5, 2.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0},  // Bug
        {0.0, 0.0, 1.0, 0.5, 1.0, 1.0, 0.5, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 2.0, 1.0},  // Ghost
        {0.5, 2.0, 0.5, 0.0, 2.0, 0.5, 0.5, 1.0, 0.5, 2.0, 1.0, 0.5, 1.0, 0.5, 0.5, 0.5, 1.0, 0.5},  // Steel
        {1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 0.5, 1.0, 0.5, 0.5, 2.0, 0.5, 1.0, 1.0, 0.5, 1.0, 1.0, 0.5},  // Fire
        {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 0.5, 0.5, 2.0, 2.0, 1.0, 0.5, 1.0, 1.0, 1.0},  // Water
        {1.0, 1.0, 2.0, 2.0, 0.5, 1.0, 2.0, 1.0, 1.0, 2.0, 0.5, 0.5, 0.5, 1.0, 2.0, 1.0, 1.0, 1.0},  // Grass
        {1.0, 1.0, 0.5, 1.0, 2.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0},  // Electric
        {1.0, 0.5, 1.0, 1.0, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 2.0, 1.0},  // Psychic
        {1.0, 2.0, 1.0, 1.0, 1.0, 2.0, 1.0, 1.0, 2.0, 2.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0, 1.0, 1.0},  // Ice
        {1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 0.5, 0.5, 0.5, 1.0, 2.0, 2.0, 1.0, 2.0},  // Dragon
        {1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 2.0, 0.5, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.5, 2.0},  // Dark
        {1.0, 0.5, 1.0, 2.0, 1.0, 1.0, 0.5, 1.0, 2.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.5, 1.0}   // Fairy
    };

/*  Ambos métodos constructores utilizan el método super() heredado de DummyMaker para instanciar
    un FightingPokemon.
*/
FightingPokemon::FightingPokemon()
    : DummyMaker() 
{
    this->level = 20;
    this->evs = 200;
    this->ivs = 15;
}

FightingPokemon::FightingPokemon(DummyMaker& dummy, int level, int evs, int ivs)
    : DummyMaker(dummy.getName(), dummy.getGeneration(), dummy.getStatus(), dummy.getType1(), dummy.getType2(), 
                 dummy.getHeight(), dummy.getWeight(), dummy.getHp(), dummy.getDefense(), dummy.getSpeed()) 
{
    this->level = level;
    this->evs = evs;
    this->ivs = ivs;
}

int FightingPokemon::getLevel() {
    return level;
}

int FightingPokemon::getIvs() {
    return ivs;
}

int FightingPokemon::getEvs() {
    return evs;
}

//  Insertando un valor string key, busca el índice en el que se encuentra el valor en el arreglo types[]
int returnIndex(string key) {
    int i = 0;
    while(i<18) {
        if(types[i] == key) {
            return i;
        }
    
        i++;
    }

    return -1;
}

/*  Este método calcula el mutiplicador de daño dado los tipos del pokemon defensor y el pokemon atacante
    usando la tabla typeEffectiveness[]. Si el defensor namas tiene un Pokemon, se hace únicamente un
    cálculo. En cambio si son dos, se realizan ambos y se multiplican los multiplicadores entre sí.
*/
double calculateTypeAmplifier(string typeAttacker, FightingPokemon defender) { // Type1 Pokemon1 vs Type1 Pokemon2
    int n = returnIndex(typeAttacker);
    int m1 = returnIndex(defender.getType1());

    if(defender.getType2() == "NONE") {
        int m2 = returnIndex(defender.getType2());
        return typeEffectiveness[n][m1]*typeEffectiveness[n][m2];
    } else {
        return typeEffectiveness[n][m1];
    }
}

void FightingPokemon::damagePokemon(string typeAttacker, FightingPokemon attacker) {
    int randomNumber = (rand() % 10) + 1;
    int randomScalar = ((rand() % 35) + 1)/35 + 1;
    int criticalBonus = 1;

    double typeAmplifier = calculateTypeAmplifier(typeAttacker, *this);

    if(randomNumber == 6) { 
        criticalBonus = 2.2;
    }

    int damage = 3*round((((0.4*attacker.getLevel()*criticalBonus+5)*1100*(2/getDefense()))/50 + 6)*randomScalar*typeAmplifier);
    setHp(getHp() - damage);

    if(typeAmplifier >= 0){
        if(typeAmplifier >= 4) { cout << "El ataque fue muy efectivo! (x4)" << endl; }
        else if(typeAmplifier >=2) { cout << "El ataque fue efectivo! (x2)" << endl; }
        else if(typeAmplifier == 0.5) { cout << "El ataque es poco efectivo (x0.5)" << endl; }
        else if(typeAmplifier == 0.25) { cout << "El ataque es muy poco efectivo (x0.25)" << endl; }

        if(criticalBonus == 2) { cout << "Ataque Crítico!" << endl; }
        cout << damage << " de ataque" << endl;
        cout << getName() << " recibió daño! HP restante: " << getHp() << endl;
    } else {
        cout << "El pokemon es inmune a ese tipo de ataque! >> " << typeAttacker  << endl;
    }
}

void FightingPokemon::printPokemon() {
    DummyMaker::printPokemon();
    cout << "Nivel: " << getLevel() << endl;
    cout << "EVs: " << getEvs() << endl;
    cout << "IVs: " << getIvs() << endl;
}
