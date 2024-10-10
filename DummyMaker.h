#ifndef DUMMYMAKER_H
#define DUMMYMAKER_H

#include <iostream>
#include <string>

using namespace std;

class DummyMaker {
    private:
        string name;
        string generation;
        string status;
        string type1;
        string type2;
        double height;
        double weight;
        int hp;
        int defense;
        int speed;

    public:
        DummyMaker();
        DummyMaker(string, string, string, string, string, double, double, int, int, int);

        string getName();
        string getGeneration();
        string getStatus();
        string getType1();
        string getType2();
        double getHeight();
        double getWeight();
        int getHp();
        int getDefense();
        int getSpeed();

        void setHp(int);

        virtual void printPokemon();
};

#endif