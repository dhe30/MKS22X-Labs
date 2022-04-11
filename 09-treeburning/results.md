#### Repetitions: 300 Boardsize: 150
Density|RESULTS
---|---
0.05|1.437
0.1|2.217
0.15|3.12
0.2|4.337
0.25|5.6
0.3|7.467
0.35|9.88
0.40|14.17
0.45|21.17
0.50|35.227
0.55|81.767
0.6|311.173
0.65|250.483
0.70|211.463
0.75|192.893
0.80|180.5933
0.85|171.54
0.90|164.407
0.95|158.187



#### Repetitions: 300 Boardsize: 150
Density|RESULTS
---|---
0.5|36.377
0.51|40.923
0.52|46.273
0.53|53.67
0.54|68.597
0.55|77.267
0.56|104.883
0.57|143.897
0.58|195.42
0.59|254.363
0.60|310.543
0.61|326.697
0.62|305.74
0.63|287.447
0.64|265.67
0.65|251.183
0.66|240.483
0.67|230.76
0.68|223.64
0.69|218.07
0.70|212.593
0.71|206.996
0.72|202.783
0.73|199.35
0.74|195.713
0.75|192.51


1. I went with 150 because 100 had too close of a gap between the smaller numbers and higher than 150 made the loop run too long.
2. The amount of repetitions needed to be bigger than my board size to cover as many cases as possible, however, 150^2 was not possible so I settled with 150*2 repetitions. The numbers were usually less than .5 apart between test cases and the runtime was within reason.  
3. The results increased each time I increased the board size. The results before the maximum had very small increases but the increase shoots up dramatically around the maximum.
4. The maximum doubles each time I double the board size, meaning they have a linear relationship. I tested this by using a loop that divided the results from a base while doubling the board size each time. The results should follow 2^n, which it did with some variation.
5. A density of 0.6 yielded the maximum burn time.
