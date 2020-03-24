
Istruzioni per la creazione degli oggetti di supporto all'asincronicita'
del servizio "fpsend".

1) creare la tabella del contatore per i retry lanciando lo script 
   "create_counter_fpsend.sql"»;
2) verificare l'esistenza sull'ambiente di deploy della QueueConnectionFactory
   di nome "java:/jms/QueueConnectionFactory";
3) creare un datasource con le seguenti caratteristiche:
   - name: CounterFpsendTxDS (standard opzionale)
   - jndi-name: fpsend/jdbc/CounterFpsendTxDS;
   - puntamento al DB che ospita la tabella creata al punto (1);
4) creare la coda associata alla PA del servizio, con jndi name = java:/queue/fpsend.jms.FpsendPAQueue;
