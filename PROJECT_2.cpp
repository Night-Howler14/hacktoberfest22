#include<stdio.h>
#include<stdlib.h>
#include<time.h>
//Game --> Snake, Water, Gun

int snakeWaterGun(char you, char comp){
    //returns 1 if you win, -1 if you lose and 0 if draw

//condition for draw
//cases covered --> ss, gg, ww
if(you == comp)
{
    return 0;
}

//not draw
//cases covered --> sg, gs, sw, ws, gw, wg
if(you == 's' && comp == 'g'){
    return -1;
}
else if(you == 'g' && comp == 's'){
    return 1;
}

if(you == 's' && comp == 'w'){
    return 1;
}
else if(you == 'w' && comp == 's'){
    return -1;
}

if(you == 'g' && comp == 'w'){
    return -1;
}
else if(you == 'w' && comp == 'g'){
    return 1;
}

}
int main(){
    char you, comp;
    int number;
    //comp = 's';  //alrady assigned value to comp
    //computer taking random variable
    srand(time(0));
    number = rand()%100 + 1;

    if(number<33){
        comp ='s';
    }
    else if( number>33 && number<66){
        comp = 'w';
    }
    else{
        comp = 'g';
    }

    printf("Enter s for snake, w for water and g for gun: \n");
    scanf("%c", &you);
    
    int result = snakeWaterGun(you, comp);

    printf("You chose %c and computer chose %c \n", you, comp);

    if (result == 0){
        printf("Game Draw! \n");
    }
    else if(result == 1){
        printf("You Win! \n");
    }
    else{
        printf("You Lose! \n");
    }

    return 0;
}