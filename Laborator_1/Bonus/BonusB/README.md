Programul �ncepe cu partea de verificare a argumentelor. Aste presupune ca daca exista argumente date la linia de comanda se testeaza daca acestea sunt unele valide prin executarea metodei ValidArgument.
Prin metoda setAdjacencyMatrix se initializeaza matricea de adiacenta a grafului d-regulat A.
Modul de calcul functioneaza �n felul urmator:
Initial fiecare nod se leaga cu d/2 vecini cei mai apropiati ai sai.
Apoi, �n cazul �n care d este impar si n par, fiecare nod se uneste cu nodul diametral opus lui.

�n final se afiseaza matricea de adiacenta a grafului d-regulat, prin intermediul metodei getMatrix.
