# springboot-vaadin-image-uploader
project done with bykowski.pl



Połączenie dwóch streamów w jeden projekt:

https://www.youtube.com/watch?v=xH6T8VQdpRo&ab_channel=PrzemekBykowski
https://www.youtube.com/watch?v=M_uKo5RdCjc&ab_channel=PrzemekBykowski
plus opis:
https://bykowski.pl/jakie-zadanie-rekrutacyjne-moze-cie-spotkac-na-rozmowie-rekrutacyjnej/


Zadanie rekrutacyjne:
Hosting zdjęć. aplikacja posiada dwa rodzaje użytkowników, których przechowuje w bazie danych( ADMIN i USER)
Po zalogowaniu admin ma możliwość dodawania zdjęć. Zalogowany użytkownk przegląda dostępne galerie.
Użytkownik niezalogowany ma formatkę logowania.

aplikacja działa w oparciu o:
springboot,
spring security (zabezpieczenia)
vaadin( frontend),
mysql( zapis danych o użytkownikach i wybranych danych o zdjęciach),
cloudinary.com - miejsce przechowywania i pobierania zdjęć poprzez API opisane na tym portalu

W stosunku do pierwotne wersji dodałem elementy które pojawiły się w streamie dotyczącym szybkiego tworzenia aplikacji w vaadin

aby korzystać z cloudinary trzeba zmienić dane w miejscu:

 cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "your cloud name",
                "api_key", "your api key",
                "api_secret", "your api secret"));

 There you must put your own credentials to work with cloudinary.
