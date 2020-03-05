$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CaseStudy.feature");
formatter.feature({
  "line": 1,
  "name": "CaseStudy Project",
  "description": "",
  "id": "casestudy-project",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Nesine Case Study",
  "description": "",
  "id": "casestudy-project;nesine-case-study",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Acilis sayfasindayim",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Giris yap butonuna tikla",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Login sayfasindayim",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Kulanici adi alanina \"14015869\" parola alanina \"seref123\" degerleri yaz ve giris yap",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Anasayfadayim",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "kupondas butonuna tıklanır",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "Kupondas sayfasindayim",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "Tum paylasimlar butonuna tikla",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Ilk hemen oyna butonu secilir",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Kupondas detay sayfasindayim",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "Kupondas detay sayfasindaki etkinlik isimlerini kaydet",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "Hemen oyna butanuna tıkla",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Basket sayfasındayim",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "Basket sayfasindaki etkinlik isimlerini kaydet",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "Kupondas detay ve basket sayfalarindaki etkinlik isimlerini karsilastir",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.acilisSayfasindayim()"
});
formatter.result({
  "duration": 28818026268,
  "status": "passed"
});
formatter.match({
  "location": "Steps.girisYapButonunaTikla()"
});
formatter.result({
  "duration": 628393776,
  "status": "passed"
});
formatter.match({
  "location": "Steps.loginSayfasindayim()"
});
formatter.result({
  "duration": 1627991190,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "14015869",
      "offset": 22
    },
    {
      "val": "seref123",
      "offset": 48
    }
  ],
  "location": "Steps.kullaniciAdiAlaninaParolaAlaninaDegerleriYazVeGirisYap(String,String)"
});
formatter.result({
  "duration": 4512074640,
  "status": "passed"
});
formatter.match({
  "location": "Steps.anasayfadayim()"
});
formatter.result({
  "duration": 2064205360,
  "status": "passed"
});
formatter.match({
  "location": "Steps.kupondasButonunaTıklanır()"
});
formatter.result({
  "duration": 2022173632,
  "status": "passed"
});
formatter.match({
  "location": "Steps.kupondasSayfasindayim()"
});
formatter.result({
  "duration": 3098907903,
  "status": "passed"
});
formatter.match({
  "location": "Steps.tumPaylasimlarButonunaTikla()"
});
formatter.result({
  "duration": 2571983974,
  "status": "passed"
});
formatter.match({
  "location": "Steps.ilkHemenOynaButonuSecilir()"
});
formatter.result({
  "duration": 1310277335,
  "status": "passed"
});
formatter.match({
  "location": "Steps.kupondasDetaySayfasindayim()"
});
formatter.result({
  "duration": 1796764079,
  "status": "passed"
});
formatter.match({
  "location": "Steps.kupondasDetaySayfasindakiEtkinlikIsimleriniKaydet()"
});
formatter.result({
  "duration": 102069137304,
  "status": "passed"
});
formatter.match({
  "location": "Steps.hemenOynaButanunaTıkla()"
});
formatter.result({
  "duration": 695301080,
  "status": "passed"
});
formatter.match({
  "location": "Steps.basketSayfasındayim()"
});
formatter.result({
  "duration": 3045231535,
  "status": "passed"
});
formatter.match({
  "location": "Steps.basketSayfasindakiEtkinlikIsimleriniKaydet()"
});
formatter.result({
  "duration": 1633963969,
  "status": "passed"
});
formatter.match({
  "location": "Steps.kupondasDetayVeBasketSayfalarindakiEtkinlikIsimleriniKarsilastir()"
});
formatter.result({
  "duration": 4774324,
  "status": "passed"
});
formatter.after({
  "duration": 969084348,
  "status": "passed"
});
});