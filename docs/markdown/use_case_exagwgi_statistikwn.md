# <center> **ΠΧ5. Εξαγωγή στατιστικών στοιχείων** </center> 
<b>Πρωτεύον actor:</b> Διαχειριστής Συστήματος <br>
<b>Ενδιαφερόμενοι:</b> Ο χρήστης του συστήματος παράγει αναφορές με στατιστικά στοιχεία. <br>
<b>Προυποθέσεις:</b> Προυποθέτει να έχει ταυτοποιηθεί απο σύστημα ως διαχειριστής. <br>
<b>Βασική Ροή:</b> 

1. Ο χρήστης έχει συνδεθεί ως διαχειριστής.
2. Ο χρήστης επιλέγει το έτος που θέλει να παράξει στατιστικά στοιχεία.
3. Ο χρήστης βρίσκει και καταγράφει το μήνα με τα μεγαλύτερα κέρδη απο την εξόφληση εισιτηρίων.
4. Ο χρήστης βρίσκει και καταγράφει τις συναυλίες που έχουν διεξαχθεί και τις ταξινομεί ως προς το πλήθος των εισιτηρίων <br>
που έχουν εξοφληθεί σε φθίνουσα σειρά.

<b>Εναλλακτικές Ροές:</b>

1. Το σύστημα εμφανίζει μήνυμα λάθους στο 2 αν δεν υπάρχουν η δεν έχουν καταγραφεί στοιχεία απο το έτος που επέλεξε.
2. Το σύστημα εμφανίζει μήνυμα λάθους στο 3,4 αν δεν υπάρχουν η δεν έχουν καταγραφεί στοιχεία κάποιου μήνα.
3. Σε περίπτωση κατάρευσης του λογισμικού εκκινεί από την αρχή την περίπτωση χρήσης.