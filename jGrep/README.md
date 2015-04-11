jGrep [![icon](http://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Glider_shadow.svg/45px-Glider_shadow.svg.png)](http://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Glider_shadow.svg/45px-Glider_shadow.svg.png) 
========

Implementierung von Grep in Java

grep ist ein Suchprogramm unter Unix. Die Eingabe besteht aus einem regulären 
Ausdruck und einem oder mehreren Files. Das Programm druckt alle Zeilen der 
angegebenen Files aus, die Teilstücke enthalten, die auf den angegebenen 
regulären Ausdruck passen. 

Hinweis (für eine Lösung mit Java):
Um ein File zeilenweise einzulesen, kann man einen BufferedReader 
(Package java.io) verwenden, zum Beispiel:

BufferedReader bufferedReader = 
    new BufferedReader(new FileReader(file));
String line = bufferedReader.readLine();

Zur Behandlung der regulären Ausdrücke sollten Sie die beiden Klassen Pattern 
und Matcher aus dem Package java.util.regex verwenden. Lesen Sie die API 
Dokumentationen dieser beiden Klassen. 

features
--------
  
* grepping over commandline
* use of regular expressions

usage
-----

grep regexp file 
grep regexp file1 [file2] ...

requirements
------------

* none

install
-------

* ...

license
-------

Copyright (c) <2014> <cynay>
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.