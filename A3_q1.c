#include <stdio.h>
#include <float.h>
#include <stdlib.h>
#include <math.h>
  
struct Point
{
    int a, b;
};
  
int compareX(const void* a, const void* b)
{
    Point *p1 = (Point *)a,  *p2 = (Point *)b;
    return (p1->a - p2->a);
}

int compareY(const void* a, const void* b)
{
    Point *p1 = (Point *)a,   *p2 = (Point *)b;
    return (p1->b - p2->b);
}
  

float dist(Point p1, Point p2)
{
    return sqrt( (p1.a - p2.a)*(p1.a - p2.a) +
                 (p1.b - p2.b)*(p1.b - p2.b)
               );
}
  
float bruteForce(Point P[], int n)
{
    float min = FLT_MAX;
    for (int i = 0; i < n; ++i)
        for (int j = i+1; j < n; ++j)
            if (dist(P[i], P[j]) < min)
                min = dist(P[i], P[j]);
    return min;
}
  

float min(float a, float b)
{
    return (a < b)? a : b;
}
  
  

float stripClosest(Point strip[], int size, float d)
{
    float min = d;  
  
    qsort(strip, size, sizeof(Point), compareY); 
  
    
    for (int i = 0; i < size; ++i)
        for (int j = i+1; j < size && (strip[j].b - strip[i].b) < min; ++j)
            if (dist(strip[i],strip[j]) < min)
                min = dist(strip[i], strip[j]);
  
    return min;
}
  

float closestUtil(Point P[], int n)
{

    if (n <= 3)
        return bruteForce(P, n);
  
    
    int mid = n/2;
    Point midPoint = P[mid];
  
    
    float dl = closestUtil(P, mid);
    float dr = closestUtil(P + mid, n-mid);
  
    
    float d = min(dl, dr);
  
    
    Point strip[n];
    int j = 0;
    for (int i = 0; i < n; i++)
        if (abs(P[i].a - midPoint.a) < d)
            strip[j] = P[i], j++;
  
    
    return min(d, stripClosest(strip, j, d) );
}
  

float closest(Point P[], int n)
{
    qsort(P, n, sizeof(Point), compareX);
  
    
    return closestUtil(P, n);
}
  

int main()
{
    Point P[] = {{2, 3}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}};
    int n = sizeof(P) / sizeof(P[0]);
    printf("The smallest distance is %f ", closest(P, n));
    return 0;
}