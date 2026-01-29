Александар Стојанчевски 233087


2. Сликата е во docs фолдер од CFG.


3.
Цикломатска комплексност

 1. if (allItems == null) 
2. for (i < allItems.size()) 
3. if (name == null || name.length()==0) 
4. if (price>300 || discount>0 || quantity>10) 
5. if (discount > 0) ... else ... 
6. if (cardNumber != null && length==16) ... else ... 
7. for (j < cardNumber.length()) 
8. if (allowed.indexOf(c) == -1)

CC = odluki + 1
CC = 9

4

Еvery statement критериум

1. allItems = null → фрла "allItems list can't be null!"
2. Item со name = null или празно → фрла "Invalid item!"
3. Нормален случај
4. Невалиден cardNumber (null или должина !=16) → фрла "Invalid card number!"
5. cardNumber со недозволен карактер (должина 16, но има буква) → фрла "Invalid character in card number!"

   Постојат 4 различни патеки кои фрлаат грешка и имаме една нормална значи вкупно 5


5.

Multiple Condition критериум за:
(price > 300 || discount > 0 || quantity > 10)
A = price > 300
B = discount > 0
C = quantity > 10

Multiple Condition бара да се покријат сите комбинации на A, B, C - 2³ = 8 тест случаи.

A | B | C | price | discount | quantity

1.  F | F | F | 100 | 0.0 | 1 |
2.  T | F | F | 301 | 0.0 | 1 |
3.  F | T | F | 100 | 0.1 | 1 |
4.  F | F | T | 100 | 0.0 | 11 |
5.  T | T | F | 301 | 0.1 | 1 |
6.  T | F | T | 301 | 0.0 | 11 |
7.  F | T | T | 100 | 0.1 | 11 |
8.  T | T | T | 301 | 0.1 | 11 |

Минимален број тест случаи: 8

6. Unit тестирање со Gradle

Проектот е креиран како обична Java апликација со Gradle.
Класата SILab2 се наоѓа во src/main/java, а тест класата SILab2Test
се наоѓа во src/test/java.

Во SILab2Test се имплементирани две тест функции:
- една за Every Statement критериум
- една за Multiple Condition критериум

Тестовите се извршуваат со командата ./gradlew test.



