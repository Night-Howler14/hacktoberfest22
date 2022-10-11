#include<stdio.h>
#include<stdlib.h>
#include<time.h>
//GAME-1 --> by harry

int main(){
    int number,guess,nguesses=1;
    srand(time(0));  //to give different nos. in different run of program
    number= rand() % 100 + 1; //generates a random no. between 1-100
    //printf("The no. is %d",number);
    
//keep running the loop until the no. is guessed
    do{
        printf("Guess the no. between 1-100 \n");
        scanf("%d",&guess);
        if(guess>number){
            printf("LOWER NO. PLEASE! \n");
        }
        else if(guess<number){
            printf("HIGHER NO. PLEASE! \n");
        }
        else{
            printf("You guess it in %d attempts \n",nguesses);
        }
        nguesses++;
    }while(guess!=number);

    
    return 0;
}