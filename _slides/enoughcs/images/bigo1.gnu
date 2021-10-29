f(x) = x
g(x) = x**2
h(x) = log(x)
i(x) = 2**x
fac(x) = gamma(x+1)

set terminal png size 1200,900
set output 'bigo1.png'

set key left top font "TilburgsAnsText,25"

set style line 1 lc rgb '#ff0000' lt 1 lw 3
set style line 2 lc rgb '#00ff00' lt 1 lw 3
set style line 3 lc rgb '#0000ff' lt 1 lw 3
set style line 4 lc rgb '#ff00ff' lt 1 lw 3
set style line 5 lc rgb '#000000' lt 1 lw 3

set style fill pattern 1

plot [0:10][0:100] '+' using 1:(15):(100) notitle with filledcurves below lc rgb '#999999', \
                   f(x) title 'N' with lines linestyle 1, \
                   g(x) title 'N^2' with lines linestyle 2, \
                   h(x) title 'log N' with lines linestyle 3, \
                   i(x) title '2^N' with lines linestyle 4, \
                   fac(x) title 'N!' with lines linestyle 5
