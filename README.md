

# Prodotto
Il prodotto ***Fonti del FSE***   realizza un sistema software che presenta in una pwa (progressive web application) i sistemi che alimentano il FSE (Fascicolo Sanitario Elettronico della Regione Piemonte) e le tipologie di documenti che vengono indicizzati. Il sistema comprende:
- una PWA che presenta le informazioni in due modalità di visualizzazione: *tabellare* e a *scheda per dispositivi mobile*
- i servizi web che leggono le informazioni dal database per renderle disponibili in JSON/REST alla PWA
- un database che memorizza le informazioni

Per visualizzare il servizio attualmente in produzione si può consultare la [pagina](https://www.salutepiemonte.it/servizi/fonti-fascicolo-sanitario-elettronico)



# Descrizione del prodotto 
Il prodotto è composto attualmente dalle seguenti componenti 
| Componente |Descrizione  |Versione |
|--|--|--|
| FONTIPWA | una PWA che presenta le informazioni in due modalità di visualizzazione: tabellare e a scheda  |-XXX-|
| DMAFONTI | i servizi web che leggono le informazioni dal database per renderle disponibili in JSON/REST alla PWA |-XXXXX-|
| FONTIDB | un database che memorizza le informazioni |-XXXXX-|



# Prerequisiti di sistema 

## Software
- [Apache 2.4](https://www.apache.org/)
- [RedHat JBoss EAP 6.4](https://developers.redhat.com/products/eap/download)
- [JDK Oracle 1.8](https://www.oracle.com/java/technologies/downloads/archive/) 
- [PostgreSQL 9.6](https://www.postgresql.org/download/)
- [CentOS 7.6](https://www.centos.org/)


# Installing
Vedere il file install.pdf nella cartella DOCS 


# Versioning
Per il versionamento del software si usa la tecnica Semantic Versioning (http://semver.org).

# Authors
La lista delle persone che hanno partecipato alla realizzazione del software sono:
- Davide Grosso
- Giovanni Pennone
- Michele Mastrorilli
- Nicola Gaudenzi
- Vanessa Alexandra Libora 
- Veronica Berti
- Yvonne Carpegna


# Copyrights
© Copyright Regione Piemonte – 2022


# License
EUPL-1.2 Compatibile
Vedere il file LICENSE.txt per i dettagli.