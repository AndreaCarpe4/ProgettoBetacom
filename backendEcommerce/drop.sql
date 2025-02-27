
    alter table carrello 
       drop 
       foreign key FK8x87h2rx8eluyrngi7eb94ia;

    alter table carrello 
       drop 
       foreign key FK776wjw2xhhhnvng0dcvarv4tg;

    alter table carrello_prodotto 
       drop 
       foreign key FKf22k9i16cc0y30kre0qf8lx16;

    alter table carrello_prodotto 
       drop 
       foreign key FK73wyc9yy2sf2epe9nkaexvbav;

    alter table ordine_prodotto 
       drop 
       foreign key FKa6uja7ct2912x00h6eoefneny;

    alter table ordine_prodotto 
       drop 
       foreign key FK5efoer90q39mh4j00d46l1y9d;

    alter table ordini 
       drop 
       foreign key FK5nvsun8bktrdr3ir2cvw0ktil;

    alter table ordini 
       drop 
       foreign key FKqj5n4mdh5tc9qkj7hx54mvgi4;

    alter table recensioni 
       drop 
       foreign key FK5wtirys8opmifrpgxxe3lla6q;

    alter table recensioni 
       drop 
       foreign key FK3qtralkbontl617niblqxy543;

    drop table if exists carrello;

    drop table if exists carrello_prodotto;

    drop table if exists messaggi_sistema;

    drop table if exists ordine_prodotto;

    drop table if exists ordini;

    drop table if exists pagamenti;

    drop table if exists prodotti;

    drop table if exists recensioni;

    drop table if exists utenti;
