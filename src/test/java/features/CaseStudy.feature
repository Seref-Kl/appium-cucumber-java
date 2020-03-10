Feature: CaseStudy Project


  Scenario: Nesine Case Study
    Given Acilis sayfasindayim
    When Giris yap butonuna tikla
    Then Login sayfasindayim
    When Kulanici adi alanina "14015869" parola alanina "seref123" degerleri yaz ve giris yap
    Then Anasayfadayim
    When kupondas butonuna tıklanır
    Then Kupondas sayfasindayim
    When Tum paylasimlar butonuna tikla
    And Ilk hemen oyna butonu secilir
    Then Kupondas detay sayfasindayim
    When Kupondas detay sayfasindaki etkinlik isimlerini kaydet
    And Hemen oyna butanuna tıkla
    Then Basket sayfasındayim
    When Basket sayfasindaki etkinlik isimlerini kaydet
    Then Kupondas detay ve basket sayfalarindaki etkinlik isimlerini karsilastir
