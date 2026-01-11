# 📜 Özlü Sözler - Inspirational Quotes App

<div align="center">

<img src="ozlu_icon.png" alt="Özlü Sözler Logo" width="120"/>

**Günlük ilham kaynağınız | Your daily source of inspiration**

[![Android](https://img.shields.io/badge/Platform-Android-green?style=for-the-badge&logo=android)](https://developer.android.com/)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0-purple?style=for-the-badge&logo=kotlin)](https://kotlinlang.org/)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-UI-blue?style=for-the-badge&logo=jetpackcompose)](https://developer.android.com/jetpack/compose)
[![API](https://img.shields.io/badge/API-30%2B-brightgreen?style=for-the-badge)](https://developer.android.com/studio/releases/platforms)

</div>

---

## 📱 Hakkında | About

**Özlü Sözler**, Türkçe olarak 470'ten fazla ilham verici söz içeren modern bir Android uygulamasıdır. Atatürk'ten Einstein'a, Mevlana'dan Steve Jobs'a kadar tarihin en önemli düşünürlerinin sözlerini keşfedin.

> *An inspirational quotes app featuring 470+ Turkish quotes from history's greatest minds — from Atatürk to Einstein, Mevlana to Steve Jobs.*

---

## ✨ Özellikler | Features

| 🇹🇷 Türkçe | 🇬🇧 English |
|-----------|-------------|
| 📅 **Günün Sözü** - Her gün yeni bir ilham | 📅 **Quote of the Day** - Daily fresh inspiration |
| 🎯 **Kategori Bazlı Filtreleme** - 10+ kategori | 🎯 **Category Filtering** - 10+ categories |
| 🎉 **Özel Gün Sözleri** - Bayramlar ve önemli günler | 🎉 **Special Day Quotes** - Holidays & special occasions |
| 📤 **Söz Paylaşımı** - Sosyal medyada paylaş | 📤 **Quote Sharing** - Share on social media |
| 📱 **Reels Deneyimi** - Kaydırarak keşfet | 📱 **Reels Experience** - Swipe to discover |
| 🌙 **Modern UI** - Jetpack Compose ile | 🌙 **Modern UI** - Built with Jetpack Compose |

---

## 📸 Ekran Görüntüleri | Screenshots

> *Ekran görüntüleri yakında eklenecek | Screenshots coming soon*

---

## 🏗️ Mimari | Architecture

```
app/
├── src/main/java/com/example/yeniuygulama/
│   ├── MainActivity.kt          # Ana aktivite
│   ├── data/
│   │   └── Quotes.kt             # 470+ söz veri katmanı
│   └── ui/
│       ├── screens/
│       │   ├── HomeScreen.kt         # Ana ekran
│       │   ├── ExploreScreen.kt      # Keşfet ekranı
│       │   ├── CategoryDetailScreen.kt # Kategori detay
│       │   └── ReelsScreen.kt        # Reels deneyimi
│       └── theme/                    # Material 3 tema
└── build.gradle.kts
```

---

## 🛠️ Teknoloji Yığını | Tech Stack

| Teknoloji | Açıklama |
|-----------|----------|
| **Kotlin** | %100 Kotlin ile yazıldı |
| **Jetpack Compose** | Modern deklaratif UI framework |
| **Material Design 3** | Google'ın en güncel tasarım sistemi |
| **Navigation Compose** | Tek aktivite navigasyon |
| **Coroutines** | Asenkron programlama |

---

## 📚 Söz Kategorileri | Quote Categories

| Emoji | Kategori | Sayı |
|-------|----------|------|
| 🇹🇷 | Atatürk | 50+ |
| 🔬 | Bilim | 30+ |
| 👔 | Girişimcilik | 40+ |
| ✊ | Liderlik | 35+ |
| 📖 | Felsefe | 50+ |
| 🎭 | Sanat | 25+ |
| ⚽ | Spor | 30+ |
| 💫 | Hayat | 100+ |

---

## 🎯 Özel Günler | Special Days

Uygulama, özel günlerde otomatik olarak temalı sözler gösterir:

- 🎆 **1 Ocak** - Yılbaşı
- ❤️ **14 Şubat** - Sevgililer Günü
- 👩 **8 Mart** - Kadınlar Günü
- 🇹🇷 **23 Nisan** - Ulusal Egemenlik ve Çocuk Bayramı
- 💐 **Anneler Günü** - Mayıs 2. Pazar
- 🇹🇷 **19 Mayıs** - Gençlik ve Spor Bayramı
- 👨 **Babalar Günü** - Haziran 3. Pazar
- 🏆 **30 Ağustos** - Zafer Bayramı
- 🕊️ **1 Eylül** - Dünya Barış Günü
- 🇹🇷 **29 Ekim** - Cumhuriyet Bayramı
- 🖤 **10 Kasım** - Atatürk'ü Anma Günü
- 📚 **24 Kasım** - Öğretmenler Günü
- 🎊 **31 Aralık** - Yılsonu

---

## 📥 İndir | Download

<div align="center">

[![APK İndir](https://img.shields.io/badge/📱%20APK%20İndir-v1.0-success?style=for-the-badge)](https://github.com/Utkuaykus/turkish-quotes-app/releases)

**Android 11 (API 30) ve üzeri gerektirir**

</div>

---

## 🛠️ Geliştiriciler İçin | For Developers

<details>
<summary>Projeyi klonlayıp çalıştırmak için tıklayın</summary>

### Gereksinimler
- Android Studio Hedgehog (2023.1.1) veya üzeri
- JDK 17
- Android SDK 34

### Kurulum

```bash
# Repository'yi klonlayın
git clone https://github.com/Utkuaykus/turkish-quotes-app.git

# Android Studio ile açın
# Sync Gradle ve Run
```

</details>

---

## 📝 Yapılacaklar | Roadmap

- [ ] Widget desteği
- [ ] Favori sözler özelliği  
- [ ] Karanlık/Aydınlık tema seçimi
- [ ] Bildirim ile günlük söz hatırlatma
- [ ] Offline çalışma modu
- [ ] Çoklu dil desteği (İngilizce)

---

## 👨‍💻 Geliştirici | Developer

**Utku** - *Mobil Uygulama Geliştirici*

[![GitHub](https://img.shields.io/badge/GitHub-Profile-black?style=flat-square&logo=github)](https://github.com/Utkuaykus)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Profile-blue?style=flat-square&logo=linkedin)](https://linkedin.com/in/utkuaykus)

---

## 📄 Lisans | License

Bu proje MIT Lisansı altında lisanslanmıştır - detaylar için [LICENSE](LICENSE) dosyasına bakın.

> This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

<div align="center">

**⭐ Beğendiyseniz yıldız vermeyi unutmayın! ⭐**

*Made with ❤️ in Turkey*

</div>
