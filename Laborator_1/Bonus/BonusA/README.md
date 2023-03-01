Programul începe cu partea de verificare a argumentului.
Aste presupune ca daca exista un argument dat la linia de comanda se testeaza daca acesta este unul valid prin executarea metodei ValidArgument.

Se formeaza matricea de adiacenta a grafului circuit Cn prim metoda setAdjacencyMatrix, care consta în setarea diagonalei de deasupra celei principale, respectiv si cea ce dedesubt, cu valori de 1, restul având implicit valoarea 0. La final pentru a obtine circuitul Cn primesc valoarea 1 ultimul element de pe prima linie si ultimul element de pe prima coloana, astfel închizându-se circuitul.
Initial exista doua matrici de adiacenta, A si powersA, cu ajutorul carora se vor obtine A2,...,An.
Rezultatul înmultirii matricelor se obtine cu metoda setPowersA, prin aplicarea clasica a regulilor de înmultire a doua matrici.
În final vor fi afisate toate metricele A1,A2,...An.
