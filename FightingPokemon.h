#ifndef FIGHTINGPOKEMON_H
#define FIGHTINGPOKEMON_H

#include <iostream>
#include <string>
#include "DummyMaker.h"

using namespace std;

class FightingPokemon : public DummyMaker {
    private:
        int level;
        int evs; // 0 -> 510
        int ivs; // 0 -> 31

    public:
        FightingPokemon();
        FightingPokemon(DummyMaker&, int, int, int);

        int getLevel();
        int getIvs();
        int getEvs();

        void damagePokemon(string , FightingPokemon);
        void printPokemon() override;
};

#endif