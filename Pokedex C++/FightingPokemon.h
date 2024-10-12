#ifndef FIGHTINGPOKEMON_H
#define FIGHTINGPOKEMON_H

#include <iostream>
#include <string>
#include "DummyMaker.h"

using namespace std;

// Fighting Pokemon hereda DummyMaker
class FightingPokemon : public DummyMaker {
    private:
        int level;
        int evs;
        int ivs;

    public:
        FightingPokemon();
        FightingPokemon(DummyMaker&, int, int, int);

        int getLevel();
        int getIvs();
        int getEvs();

        void damagePokemon(string, FightingPokemon);

        // Sobrecargado de la clase padre DummyMaker
        void printPokemon() override;
};

#endif
