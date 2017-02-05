/**
 * Animal struct demonstrating a few ways to use struct in C.
 * Author: Zhuo Lu
 */

#include <stdlib.h>
#include <stdio.h>

typedef struct animal {
  int height;
} animal;

int cmpheight(animal a, animal b) {
  if (a.height < b.height) {
    return -1;
  } else if (a.height == b.height) {
    return 0;
  } else {
    return 1;
  }
}

int main(int argc, char *argv[]) {
  // Tiger
  animal tiger = {200};

  // Mouse
  animal mouse;
  mouse.height = 5;

  // Dog
  animal *dog;
  dog = malloc(sizeof(animal));
  dog->height = 40;

  printf("tiger height: %d\n", tiger.height);
  printf("mouse height: %d\n", mouse.height);
  printf("dog height (test 1): %d\n", dog->height);
  printf("dog height (test 2): %d\n", (*dog).height);

  printf("cmpheight tiger, mouse: %d\n", cmpheight(tiger, mouse));
  printf("cmpheight dog, tiger: %d\n", cmpheight(*dog, tiger));
  printf("cmpheight mouse, dog: %d\n", cmpheight(mouse, *dog));

  // Avoid memory leaking
  free(dog);
}
