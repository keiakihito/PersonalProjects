#ifndef LAB_H
#define LAB_H

using namespace std;

int **init_lab(int* stations);
bool login(int** labs, int lab, int station, int id);
bool logout(int** labs, int* sizes, int id);

#endif //LAB.h