package fr.o80.aoc.day11.part2

const val exercise_d11_p2 = """LLLLLL.LLLL..LLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLL.LLLLLL.L.LL.LLLLLL.LLLLLLLLLLLLLLLL
LLLLLL.LLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLL.LLL.LLLL.L.LLLLLL.LLLLLLLLLLLL.LLLLLLLL
LLLLLLLL.LLL.LL..LLLLLLLLL.L.LLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLL
LLLLLL.LLLLL.LLL.LLLLLLLLL.LLLLLLLLLLL.LL.LLLLLL.LLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLL.LLLLLLLLL.LLLLLL
LLLLLLLLLLLLL.LL.LLLLLLLLL..LLL.LLLLLLLLLLLLLLLLLLL.LLLLL.LLLLL.LLLLLL.LLLLLLLLLLL.LLLLLLLLL.LLLLLL
LL..L.LLL.....L.L.L.....LL..L.LLLL..LL..LL..L.L.L.........LL.L..L..LL.L...L.LL..........LL....L.L..
L.LLLLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLL.LLLLLL
.LLLLLLLLLLLLLLLL.LLLLLLLL.LLLL.LLLLLLLLL.LLLLLL.LLL.LLLL.LLLLL.LLLLLL.LLLL.LLLLLL.LLLLLLLLL.LLL.LL
LLL.L..LLLLLLLLL..LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL.LL.LLL.LLLL.LLLLLL.LLLLLLLLL.LLLLLL
.LLLLL.LLLLLLLLL.LLLLLLLLLLLLLL..LLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLL..LLL.LLLLLLLLLLLLLLLL.LLLLLL
LLLLLLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLL.LLLLL..LLLLLLLLLLLLLLLL
LLLLL.LLLLLLLLLLLL.LLLLLLLLLLLL.LLL.LLLLL.LLLLLL.LLL.LLLLLLLLLL.L.L.L..LLLL.LLLLLL.LLLLLLLLL.LLLLLL
LLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLL.LLLL.LLLLL..LLLLLLLLL.LLLLLL
..L....L......L..L..L.......LL.L..L............LL.LL.L.L.L..........L..L.L.LL.L.LL......L.L....L..L
LLLLLL.LLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLLLLL.L.LLLLLLLLLLLLLLL.LLLLLL.LLLL.LLLLLLLLLLL
.LLLLL.LLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLL.LLL.LLLLLLLLLL.LLLLLL.LL.LLL.LLLL.LLLLLL.LLLLLLLLL.LLL.L.
LLLLL..LLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LL.LLLLLLLLLLLLLLLLLL.LLLLLL.LLLL.LLLLLL.LLLLLLLLL.LLLLLL
LLLLLL.LLLLLLL.L.L.LLLLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLLLLL.LLLLL.LLLL.LLLLLL.LLLLLL.LLLLLLLLLLLLLLLL
LLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLL.LL.LLLL.LLLLLLLLLLLL.LLL.LLLLLL
L.LLLL.L.LLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLL.LLLLLLLL.LLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLL
L.L...L...LL....LL....L..L.L.LLLL..LL..L.L....L.LL.L..L.L..LL.L..L..L..LLL..L..L..........L........
LLLLLL.LLL.LLL.L.LLLLLLLLL.LLLLLLL.LLLLLL.LLL.LL.LLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLL
LLLLLL.LLLLLLLLLLLLLLLLLLL.L.LL.LLLLLLLLL.L.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLL
LLLLLL.LLLLLLLLLLLLLLLLLLL.LLLL.LLLLL.LLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLL
LLLLLL..LLLLLLLL.LL.LLLLLL.LLLL.LLLLLLLLL.LLLLL...L.LL.LL.LLLLL.LLLLLLLL.LL.LLLL.L.LL.LLLLLL.LLLLLL
LLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLL.LLLLLL..LLLLL.LLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLL.LLL
L..LL...............L...L.......LLL.....LL...L.........L.....L...L..L.......L.LLLL..L.L..LL.LL....L
LLLLLL.LLLLLLLLL.LLLLLL.LL.LLLL.LLLLLLLLL.LLLLLL.LLLLLL.LLLLLLL.LLL.LL.LLLLLLLLLLL.LLLLLLLLL.LLLLLL
LLLLLL.LLLLLLLLLLLLLLLL.LL.LLLL.LLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLL.LLLL.LLLLLL.LLLLL.LLL.LLLLLL
LLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLL.LLLLLL.LLLLLLLLLLL..LLLLLLLLLLLLLLL
.LLLLLLL.LLLLLLL.LLLLLLLLL..LLL.LLLLLLLLL..LLLLL.LLLLLLLL.LLLLL.LLLLLL.LLLL.L.L.LL..LLLLLLLL.L.LLLL
LLLLLLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLL..LLLL.LLL.LL.LLLLLLLLL.LLLLLL
LLLLLLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLL.LLL.L.LLLLL.
LLLLLLLLLLLLLLLLLLLLLLLLLL.LLLL.LL.LLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLL..LLLLLLLLLLL.LLLLLLLLL.LLLLLL
....L....L.L...L....L..L........L.L..LLL..L.L.L.L..L..L.....L.L....LL...LL..L..LL..LLL....LL...LL.L
.LLLLLLLLLLLLLLL.LLLLLLLLL..LLLLLLLLL.LL..LLLLLL.L.LLLLLL.LLLLLLL.LLLL.LLLLLLLLLL..LLLLLLLLL.LLLLLL
LLLLLL.LLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL...LLLL.LLLL.LLLLLLLLLL.LLLLLLLLLLLL
LLLLLL.LLL.LLLLL.LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLL.LLLLLL.LL.LLLLLLLLLLLLL
LLLLLLLL.LLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.L.LLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLLL
LLLLLLLLLLLLL.LLL.LLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLL.LLLLL.LLL.L..LLLLLLLLLLL.LLLLLLLLL.LLLLLL
LLLLLLL.LLLLLL.L.LLLLLLLL.LLLLL.LLLLLLLLL.LLLLLL.LLLLL.LL.LLLLLLLL.LLL.LLLL.LLLLLL.LLLLLLLLL.LLLLLL
LLLLLL.LLLLLLLLL.LLLLLLL.L.LLLL.LLLLLLLLL.LLLLLLLLLLL.LLL.LLLLL.LLLLLL.LLLL.LLLLLL.LLLLLLLLLLL.LLLL
LLLLLL.LLLLLLLLL.LLLLLLLLL.L.LLL.LLLLLLLL.LLLLLL.LLLLLLLL.LLLLL.LLLLLL..LLLLLLLLLL.LL.LLLLLL.LLLLLL
LLLLLL.LLLLLLLLL.L.LLLLLLL.LLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLL.LLL.LLLLLL.LLLL.LLLLLL.L.LLL.LLL.LLLLLL
...........L...L.......L.LL...LL.L.L.L..L..L.L.LL.LLLL.LLL..LLL.L.L..L.L.LL.L..L....LLLLLL...L.....
LLLL.L.LLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLL..L.LLLLL.LLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLL.L.L.LLLL
LLLLLLLLLL..LLLL.LLLLLLLLL.LLLLLLLLLL.LLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLL.LLLL.LLLLLL.LLLLLLLLL.L.LLLL
LLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLL.LLLLL..LLLLLLLL.LLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLL.
LL.LLLLLLLLLLLLL.LLLLLLLLL.LLL..LLLLLLLLLLLLLLLL.LLL.L.LL.LLLLL.LLLLLL.LLLL.LLLLLL.LLLL.LLLL.LLL.LL
LLLLLL.LLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLL..LLLLLLLLLLLLLL.LLLLL.LLLLLL.LLL.LLLLLLL.LLLLLLL.L.LLLLLL
LLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLL.LLLLLLLL.LLLLLLLLLLL.LLLLLLLLL.LLLLLL
L...LLLLL.L.L.L.L........L...L...L.LLL...L..LL.LLL.L..LL..........L.LL.LL......L.L.........LLL.LLL.
LLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLL..LLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLLLL.LLLLLL
LLLLLLLLLLLLLLLL.LLLLLLL.LLLLLL.LLLLLLLLL.LLLL.L.LLLLLL.L..LLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLL
LLLL.L.LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLL.LLLLLLLLLL.LLLLLL.L.LLLLLLLLLLLLLLLLLL..LLLLLL
LLLLLL.LLLLLL..L.LLLLLLLLL.L.LL.LLLLLLLLL.LLLLLLLLLL.LLLL..LLLLLLLLLLL.LLLL.LLLL.L.LLLLLLLLLLLLLLLL
LLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LL..LLLLL.LLLLL.LLLLLLLLLLLLLL..LLLL.L.LLLLLLLLLLL.LLLLLLLLL.LLLLLL
LLLLLL.LLLLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLL.LLLLLL.LLLL.LLLLLL.LLLLLLLLL.LLLLLL
LLLLLLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLL.LLLLLLLLL.LL.L.LL.LLL.LLLL.LLLLLLLLLLLLLLLL.LLLLLL
L...LL.L.LL.LL..L.....L...L.L.L.L..LL....LL.L.L......L..L...L..LLL....LL.L.LLLL.L.LL.L..LLL.....L.L
LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLL.L.LLLLLLLLLL
.LLLLL.LLLLLLLLL.LLLLLLLLL.LL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLLLL.LLLLLL
LLLLLL.LL.LLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLL.LLLLLLLLL.LLLLLL
LLLLLL..LLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLL
LLLLLL.LLLLLLLLL.LLLLL.LLL.LLLL.LLLLLLLLLLLLL.LLLLLLLL.LL.L.LLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLL.LLLLL.
.L.......L....L.LL....L..L.......LL..L..L..L..LL..L...L......LLLL.L.......L.L.L...LL.LL.L.L...LLL..
LLLLLL.L.LLLLLLL.LLLLLLLLLLL.LLLLL..LLLLL.LLLLLL.LLLLLLLL.LLLLL.LLLLLLLLLLL.LLLLLL.LLLLLLLLL.LLLLLL
LLLLLL.LLLLLLLLL.LL.LLLLLLLLLLLLL..LLLLLL.LLLLLL.LLLLLLLL.LLLLL.LLLLLL.LLLLLLLLLLL.LLLLLLLLL.LLLLLL
LLLLLL.LLLLLLLLL.LLLLLLLLL.L.LL.LLLLLLL.L.LLLLLL.LL..LLLL.LLLLLL.L.LLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLL
LLLLLL.L.L.LLLLL.LLLLLLLLLLLLLL.L.LLLLLLL.LLLLLLL.LLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLL.
LLLLLL.LLLLLLLLLLL.LL.LLLL.LLLL.LLLLLLLLL.LLLLLL.LLLLLLLLLL.LLL.LLLLLL.LLLL.LLLLL..LLLLLLLLL.LLLLLL
LLL..LLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLL..LLLLLLLLLLLLLLL
LLLLLL.L.LLLLLLL.LLLLLLLLL..LLL.LLLLLLLLLLLL.LLLLLLLLLLLL.LLL.LLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLL
.....LLL..........L.....L..L...LL.....LL...L...L.L....L..L.LL.L.L.LL.L.L.LLL.L.L.L..L.LL.L....LL...
LLLLL..LLLLLLLLL.LLLLLLLLL.L.LLLLLLL.LLLL.LLLLLLLLLLLLLLLLLL.LL.LLLLLL.LLLL.LLLL.LLLLLLLL.LL.LLLLLL
L.LLLL.LLLLLLLLL.LL.LLLLLL.LL.L..LLLLLLLL.LLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLLL..LLLLL..LLLLLLLL.L.L.LL
LL.LLLLLLLLLLLLL.LLLLLLLL.LLLLL.LLLLLLLLL.LLLLL.L.LLLLLLL.LLLLL.LLLLLL.LLLL.LLLLL..LLLLLLLLL.LLLLLL
LLLLL..LLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLL.LLLLLL.LLLLLLLLLLLLLL.LLL.LL.LLLL.LLLLLL.LLLLLLLLL.LLLLLL
LL.LLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL.L.LLLLLL.LLLLL.LLLLLL.LLLLLLLLLLL.LLLLLLLLL.LLLLLL
L.L.....LL........L..L....L.....LLL.L.L.L........L.........L........L..L..L..L.....L....LLL..L..LL.
L.LLLL.LLL.LLLLLLL.LLLLLLL.LLLL.LLLLLLLLL.LLLLLL.LLLLLLL..LLLLL.LLLLLLLLLLLLLLLLL..LLLLLLL.L.LLLLLL
LLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLL.L.LLLLLL.LLLL.LLLLLL.LLLLLLLLLLLLLLLL
LLLLLL.LLLLLLLLL.LLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLLLLLLL...LLLL.LLLLLL.LLLLLLLLLLL.LLLLLLLLL.LLLLLL
LLLL.L.LL.L.LLLL.LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLL.LLLLLLLL.LLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLL.L.L.LLLL
LL.L.L.L..L..L..L....L....L.L.LLL.L.LLL.......L..LL.....LLL......L.L.L.L..L.LLL...L.......L........
LLLLLL.LLLLLLLLL.LLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLL.LLLLLL.LLLL.LLLLLL.LLLLLLLLL.LLLLLL
LLLLLL.LLLLLLLLL.LL.LLLLLLLLLLLLLLL..LLLL.LLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLL
LLLLLL.LLLLLLL.L.L.LLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLL.LL.LLLLL.LLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLL
LLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLL.LLLLL..LLLLLLLLLL.LLL.LLLL..LLLLL.LLLLLLL.LL.LLLLL
LLLLLLLLLLLLLLLL.LLLL.LLLL.LLLLLLL.LLLLLL.LLLLLLLLLLLLLLL.LLLLL.LLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLL"""
