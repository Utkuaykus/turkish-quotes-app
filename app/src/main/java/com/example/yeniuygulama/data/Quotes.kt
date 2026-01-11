package com.example.yeniuygulama.data

data class Quote(
    val id: Int,
    val text: String,
    val author: String,
    val title: String,
    val category: String
)

object QuotesData {
    
    // Tüm sözleri birleştiren fonksiyon
    fun getAllQuotes(): List<Quote> {
        return quotesPartOne + quotesPartTwo + quotesPartThree + quotesPartFour + quotesPartFive + quotesPartSix + quotesPartSeven + quotesPartEight + quotesPartNine + specialQuotes
    }
    
    // Özel günler için ek sözler
    private val specialQuotes = listOf(
        Quote(471, "Hayat bir çiçek, aşk onun balıdır.", "Victor Hugo", "Fransız Yazar", "Hayat")
    )
    
    // Günün sözünü getir (özel günler + epoch day)
    fun getQuoteOfTheDay(): Quote {
        val allQuotes = getAllQuotes()
        val today = java.time.LocalDate.now()
        
        // Özel günler için kontrol
        getSpecialDayQuote(today)?.let { return it }
        
        // Normal günler için epoch day kullan (tüm sözler gösterilir)
        val epochDay = today.toEpochDay()
        return allQuotes[(epochDay % allQuotes.size).toInt()]
    }
    
    // Özel gün sözünü getir
    private fun getSpecialDayQuote(date: java.time.LocalDate): Quote? {
        val month = date.monthValue
        val day = date.dayOfMonth
        
        return when {
            // 1 Ocak - Yılbaşı
            month == 1 && day == 1 -> getQuoteById(269) // "Her yeni gün, yepyeni bir sayfa."
            
            // 14 Şubat - Sevgililer Günü
            month == 2 && day == 14 -> getQuoteById(471) // Victor Hugo - "Hayat bir çiçek, aşk onun balıdır."
            
            // 8 Mart - Kadınlar Günü
            month == 3 && day == 8 -> getQuoteById(14) // "Dünyada her şey kadının eseridir." - Atatürk
            
            // 23 Nisan - Ulusal Egemenlik ve Çocuk Bayramı
            month == 4 && day == 23 -> getQuoteById(12) // "Egemenlik, kayıtsız şartsız ulusundur." - Atatürk
            
            // Anneler Günü - Mayıs 2. Pazar
            isMotherDay(date) -> getQuoteById(25) // "Ey Kahraman Türk kadını..." - Atatürk
            
            // 19 Mayıs - Gençlik ve Spor Bayramı
            month == 5 && day == 19 -> getQuoteById(7) // "Bütün ümidim gençliktedir." - Atatürk
            
            // Babalar Günü - Haziran 3. Pazar
            isFathersDay(date) -> getQuoteById(346) // "Herkes kendi işini kendisi görmelidir." - Atatürk
            
            // 30 Ağustos - Zafer Bayramı
            month == 8 && day == 30 -> getQuoteById(6) // "Zafer, 'Zafer benimdir' diyebilenindir." - Atatürk
            
            // 1 Eylül - Dünya Barış Günü
            month == 9 && day == 1 -> getQuoteById(4) // "Yurtta sulh, cihanda sulh." - Atatürk
            
            // 29 Ekim - Cumhuriyet Bayramı
            month == 10 && day == 29 -> getQuoteById(15) // "Cumhuriyeti biz kurduk..." - Atatürk
            
            // 10 Kasım - Atatürk'ü Anma Günü
            month == 11 && day == 10 -> getQuoteById(5) // "Benim manevi mirasım bilim ve akıldır." - Atatürk
            
            // 24 Kasım - Öğretmenler Günü
            month == 11 && day == 24 -> getQuoteById(10) // "Milletleri kurtaranlar öğretmenlerdir." - Atatürk
            
            // 31 Aralık - Yılsonu
            month == 12 && day == 31 -> getQuoteById(470) // "Ve yolculuk devam ediyor..."
            
            else -> null
        }
    }
    
    // ID'ye göre söz getir
    private fun getQuoteById(id: Int): Quote? {
        return getAllQuotes().find { it.id == id }
    }
    
    // Anneler Günü kontrolü (Mayıs ayının 2. Pazarı)
    private fun isMotherDay(date: java.time.LocalDate): Boolean {
        if (date.monthValue != 5) return false
        if (date.dayOfWeek != java.time.DayOfWeek.SUNDAY) return false
        // 2. Pazar: 8-14 arasında olmalı
        return date.dayOfMonth in 8..14
    }
    
    // Babalar Günü kontrolü (Haziran ayının 3. Pazarı)
    private fun isFathersDay(date: java.time.LocalDate): Boolean {
        if (date.monthValue != 6) return false
        if (date.dayOfWeek != java.time.DayOfWeek.SUNDAY) return false
        // 3. Pazar: 15-21 arasında olmalı
        return date.dayOfMonth in 15..21
    }
    
    // Kategoriye göre sözleri getir
    fun getQuotesByCategory(category: String): List<Quote> {
        return getAllQuotes().filter { it.category == category }
    }
    
    // Tüm kategorileri getir
    fun getAllCategories(): List<String> {
        return getAllQuotes().map { it.category }.distinct()
    }
    
    // PART 1: Quotes 1-85
    private val quotesPartOne = listOf(
        // 🇹🇷 ATATÜRK
        Quote(1, "Hayatta en hakiki mürşit ilimdir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(2, "Ne mutlu Türküm diyene.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(3, "Egemenlik verilmez, alınır.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(4, "Yurtta sulh, cihanda sulh.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(5, "Benim manevi mirasım bilim ve akıldır.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(6, "Zafer, 'Zafer benimdir' diyebilenindir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(7, "Bütün ümidim gençliktedir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(8, "Türk, öğün, çalış, güven.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(9, "Sanatsız kalan bir ulusun hayat damarlarından biri kopmuş demektir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(10, "Milletleri kurtaranlar yalnız ve ancak öğretmenlerdir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(11, "Benim naçiz vücudum elbet bir gün toprak olacaktır, ancak Türkiye Cumhuriyeti ilelebet payidar kalacaktır.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(12, "Egemenlik, kayıtsız şartsız ulusundur.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(13, "Ey yükselen yeni nesil, istikbal sizsindir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(14, "Dünya üzerinde gördüğümüz her şey kadının eseridir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(15, "Cumhuriyeti biz kurduk, onu yükseltecek ve sürdürecek sizlersiniz.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(16, "Öğretmenler! Cumhuriyet sizden düşünceleri hür, vicdanı hür, irfanı hür nesiller ister.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(17, "Hiçbir şeye ihtiyacımız yok, yalnız bir şeye ihtiyacımız vardır: Çalışkan olmak!", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(18, "Doğruyu söylemekten korkmayınız.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(19, "Yurt sevgisi ona hizmetle ölçülür.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(20, "Bağımsızlık, uğruna ölmesini bilen toplumların hakkıdır.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(21, "Milli egemenlik öyle bir nurdur ki, onun karşısında zincirler erir, taç ve tahtlar batar.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(22, "Türkiye Cumhuriyetinin temeli kültürdür.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(23, "Eğer bir gün benim sözlerim bilimle ters düşerse, bilimi seçin.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(24, "Bilim ve fen nerede ise oradan alacağız ve her ulus kişisinin kafasına koyacağız.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(25, "Ey Kahraman Türk kadını, sen omuzlar üzerinde göklere yükselmeye layıksın.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(26, "Beni görmek demek mutlaka yüzümü görmek demek değildir. Benim fikirlerimi anlıyorsanız bu yeterlidir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(27, "Cumhuriyeti kuranlar onu korumaya da muktedir olmalıdır.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(28, "Adalet gücü bağımsız olmayan bir milletin devlet halinde varlığı kabul olunmaz.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(29, "Memleketin efendisi hakiki müstahsil olan köylüdür.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(30, "Türkiye Cumhuriyeti mesut, muvaffak ve muzaffer olacaktır.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        
        // 🔬 BİLİM İNSANLARI
        Quote(31, "Hayal gücü bilgiden daha önemlidir.", "Albert Einstein", "Fizikçi, Nobel Ödüllü", "Bilim"),
        Quote(32, "Hayat bisiklete binmek gibidir. Dengede kalmak için hareket etmelisin.", "Albert Einstein", "Fizikçi, Nobel Ödüllü", "Bilim"),
        Quote(33, "Hiç hata yapmamış insan, yeni bir şey denememiş demektir.", "Albert Einstein", "Fizikçi, Nobel Ödüllü", "Bilim"),
        Quote(34, "Başarılı olmaya değil, değerli olmaya çalış.", "Albert Einstein", "Fizikçi, Nobel Ödüllü", "Bilim"),
        Quote(35, "Asla sorgulamayı bırakma.", "Albert Einstein", "Fizikçi, Nobel Ödüllü", "Bilim"),
        Quote(36, "Zorlukların ortasında fırsat yatar.", "Albert Einstein", "Fizikçi, Nobel Ödüllü", "Bilim"),
        Quote(37, "Hayatta korkulacak hiçbir şey yok. Sadece anlaşılacak şeyler var.", "Marie Curie", "Fizikçi, 2x Nobel Ödüllü", "Bilim"),
        Quote(38, "Beni amacıma götüren sırrı söyleyeyim: Gücüm yalnızca azmime dayanıyor.", "Louis Pasteur", "Mikrobiyolog", "Bilim"),
        Quote(39, "Başarısızlık da bir seçenektir. Başarısız olmuyorsan, yeterince risk almıyorsun!", "Elon Musk", "Girişimci, SpaceX & Tesla CEO", "Bilim"),
        Quote(40, "Muhteşem bir şey, bir yerlerde keşfedilmeyi bekliyor!", "Carl Sagan", "Astrofizikçi", "Bilim"),
        Quote(41, "Yaşam ne kadar kötü görünse, yapabileceğiniz bir şey mutlaka vardır.", "Stephen Hawking", "Fizikçi", "Bilim"),
        Quote(42, "Değişime adapte olan hayatta kalır, en güçlü veya en zeki olan değil.", "Charles Darwin", "Biyolog", "Bilim"),
        Quote(43, "Daha ilerisini gördüysem, devlerin omuzlarında durmaktandır.", "Isaac Newton", "Fizikçi, Matematikçi", "Bilim"),
        Quote(44, "İnsanlar konusunda daha az, fikirler konusunda daha çok meraklı olun.", "Marie Curie", "Fizikçi, 2x Nobel Ödüllü", "Bilim"),
        Quote(45, "Bilim ve sanat, itibar görmediği toplumları terk eder.", "İbn-i Sina", "Filozof, Hekim", "Bilim"),
        
        // 👔 GİRİŞİMCİLER
        Quote(46, "Vaktin kısıtlı, başkasının hayatını yaşayarak harcama.", "Steve Jobs", "Apple Kurucusu", "Girişimcilik"),
        Quote(47, "Aç kal, aptal kal.", "Steve Jobs", "Apple Kurucusu", "Girişimcilik"),
        Quote(48, "Harika iş yapmanın tek yolu, yaptığın işi sevmektir.", "Steve Jobs", "Apple Kurucusu", "Girişimcilik"),
        Quote(49, "Lideri takipçiden ayıran şey inovasyondur.", "Steve Jobs", "Apple Kurucusu", "Girişimcilik"),
        Quote(50, "Dünyayı değiştirebileceklerini düşünecek kadar deli olanlar, gerçekten değiştirenlerdir.", "Steve Jobs", "Apple Kurucusu", "Girişimcilik"),
        Quote(51, "Hiç hata yapmamış bir insan, hiçbir şey denememiş demektir.", "Henry Ford", "Ford Motor Kurucusu", "Girişimcilik"),
        Quote(52, "Hatalar değil, çareler bulun.", "Henry Ford", "Ford Motor Kurucusu", "Girişimcilik"),
        Quote(53, "Yapabileceğini düşünsen de düşünmesen de haklısın.", "Henry Ford", "Ford Motor Kurucusu", "Girişimcilik"),
        Quote(54, "Önümüzdeki yüzyılda liderler, başkalarını güçlendiren kişiler olacak.", "Bill Gates", "Microsoft Kurucusu", "Girişimcilik"),
        Quote(55, "Bugün zor, yarın daha zor, ama ertesi gün güneşli.", "Jack Ma", "Alibaba Kurucusu", "Girişimcilik"),
        Quote(56, "Başarı, hazırlanmış birinin fırsatla buluşmasıdır.", "Oprah Winfrey", "Medya Patronu", "Girişimcilik"),
        Quote(57, "Hayatınız, onu anlatmaya cesaret ettiğiniz hikayedir.", "J.K. Rowling", "Yazar, Harry Potter Yazarı", "Girişimcilik"),
        Quote(58, "Bitmiş bir şey, mükemmel bir şeyden iyidir.", "Sheryl Sandberg", "Facebook COO", "Girişimcilik"),
        
        // ✊ LİDERLER
        Quote(59, "Dünyada görmek istediğin değişim sen ol.", "Mahatma Gandhi", "Hindistan Bağımsızlık Lideri", "Liderlik"),
        Quote(60, "Yarın ölecekmiş gibi yaşa. Sonsuza dek yaşayacakmış gibi öğren.", "Mahatma Gandhi", "Hindistan Bağımsızlık Lideri", "Liderlik"),
        Quote(61, "Gelecek, bugün ne yaptığımıza bağlıdır.", "Mahatma Gandhi", "Hindistan Bağımsızlık Lideri", "Liderlik"),
        Quote(62, "Zayıflar asla affetmez. Affetmek güçlülerin özelliğidir.", "Mahatma Gandhi", "Hindistan Bağımsızlık Lideri", "Liderlik"),
        Quote(63, "Nazik bir şekilde dünyayı sarsabilirsin.", "Mahatma Gandhi", "Hindistan Bağımsızlık Lideri", "Liderlik"),
        Quote(64, "İmkansız görünür, ta ki yapılana kadar.", "Nelson Mandela", "Güney Afrika Devlet Başkanı", "Liderlik"),
        Quote(65, "Başarı kesin değildir, başarısızlık ölümcül değildir. Önemli olan devam etme cesaretedir.", "Winston Churchill", "İngiltere Başbakanı", "Liderlik"),
        Quote(66, "Başarı, coşkunuzu kaybetmeden başarısızlıktan başarısızlığa yürümektir.", "Winston Churchill", "İngiltere Başbakanı", "Liderlik"),
        Quote(67, "Yapabileceğine inan, yarı yoldasın.", "Theodore Roosevelt", "ABD Başkanı", "Liderlik"),
        
        // 📚 FİLOZOFLAR
        Quote(68, "Bir şey biliyorum, o da hiçbir şey bilmediğimdir.", "Sokrates", "Antik Yunan Filozofu", "Felsefe"),
        Quote(69, "Kendini bil.", "Sokrates", "Antik Yunan Filozofu", "Felsefe"),
        Quote(70, "Kalite, bir eylem değil bir alışkanlıktır.", "Aristoteles", "Antik Yunan Filozofu", "Felsefe"),
        Quote(71, "Beni öldürmeyen şey güçlendirir!", "Friedrich Nietzsche", "Alman Filozof", "Felsefe"),
        Quote(72, "Mutluluk hazır bir şey değildir. Kendi eylemlerinizden gelir.", "Dalai Lama", "Tibet Ruhani Lideri", "Felsefe"),
        Quote(73, "En uzun yolculuk tek bir adımla başlar.", "Lao Tzu", "Çinli Filozof", "Felsefe"),
        
        // 🎭 SANATÇILAR & YAZARLAR
        Quote(74, "Tüm hayallerimiz gerçek olabilir, onları kovalama cesaretimiz varsa.", "Walt Disney", "Animatör, Disney Kurucusu", "Sanat"),
        Quote(75, "İmkansız diye bir şey yok. Kelimenin kendisi 'ben mümkünüm' diyor!", "Audrey Hepburn", "Aktris", "Sanat"),
        Quote(76, "Hayat kendinizi bulmakla ilgili değil. Kendinizi yaratmakla ilgili.", "George Bernard Shaw", "İrlandalı Yazar", "Sanat"),
        Quote(77, "Başlamanın sırrı, yapmaya başlamaktır.", "Mark Twain", "Amerikalı Yazar", "Sanat"),
        Quote(78, "Büyük işler, küçük işlerin bir araya gelmesiyle yapılır.", "Vincent Van Gogh", "Ressam", "Sanat"),
        
        // 🏆 SPOR
        Quote(79, "Acı geçicidir. Pes etmek sonsuzdur.", "Lance Armstrong", "Bisikletçi", "Spor"),
        Quote(80, "Kaybetmekten korkmaktan, kazanma heyecanın daha büyük olsun.", "Simone Biles", "Jimnastikçi", "Spor"),
        
        // 💫 HAYAT
        Quote(81, "Hayatın %10'u başımıza gelenler, %90'ı tepkimizdir.", "Charles Swindoll", "Yazar", "Hayat"),
        Quote(82, "Atmadığın şutların %100'ünü kaçırırsın.", "Wayne Gretzky", "Buz Hokeycisi", "Hayat"),
        Quote(83, "Başarı, her gün tekrarlanan küçük çabaların toplamıdır.", "Robert Collier", "Yazar", "Hayat"),
        Quote(84, "Bir yıl sonra, keşke bugün başlasaydım diyeceksin.", "Karen Lamb", "Yazar", "Hayat"),
        Quote(85, "Konfor alanının dışına çık. Büyüme orada olur.", "Roy T. Bennett", "Yazar", "Hayat")
    )
    
    // PART 2: Quotes 86-150
    private val quotesPartTwo = listOf(
        Quote(86, "Cumhuriyet düşünce serbestliği taraftarıdır.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(87, "Kadınları geri bırakan toplumlar geride kalmaya mahkumdur.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(88, "Gençler cesaretimizi takviye ve idame eden sizlersiniz.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(89, "Sizlere saldırmanızı değil, ölmenizi emrediyorum.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(90, "Süngülerle kazandığımız zaferlerden sonra, kültür ve ekonomi alanlarında da zaferler kazanmaya devam edeceğiz.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(91, "Problemlerimizi, onları yarattığımız düşünce düzeyiyle çözemeyiz.", "Albert Einstein", "Fizikçi, Nobel Ödüllü", "Bilim"),
        Quote(92, "Delilik: Aynı şeyi yapıp farklı sonuç beklemektir.", "Albert Einstein", "Fizikçi, Nobel Ödüllü", "Bilim"),
        Quote(93, "Mantık sizi A'dan B'ye götürür. Hayal gücü ise her yere.", "Albert Einstein", "Fizikçi, Nobel Ödüllü", "Bilim"),
        Quote(94, "Evrendeki tüm enerjiden daha güçlü bir güç vardır: İnsan iradesi.", "Nikola Tesla", "Mucit, Elektrik Mühendisi", "Bilim"),
        Quote(95, "Bugünün hayal ettiğiniz şey, yarının gerçeği olacaktır.", "Nikola Tesla", "Mucit, Elektrik Mühendisi", "Bilim"),
        Quote(96, "Fikirler kolaydır. Uygulama her şeydir.", "Jack Welch", "General Electric CEO", "Girişimcilik"),
        Quote(97, "En büyük risk hiç risk almamaktır.", "Mark Zuckerberg", "Facebook Kurucusu", "Girişimcilik"),
        Quote(98, "Kötü haberler iyi haberlere dönüşebilir, eğer gerekli aksiyonları alırsanız.", "Jeff Bezos", "Amazon Kurucusu", "Girişimcilik"),
        Quote(99, "Fiyat, ödediğinizdir. Değer, aldığınızdır.", "Warren Buffett", "Yatırımcı", "Girişimcilik"),
        Quote(100, "İyi liderler başkalarının kendilerine güvenmesini sağlar.", "Eleanor Roosevelt", "ABD First Lady", "Liderlik"),
        Quote(101, "Bir lider; yolu bilen, yola giren ve yol gösteren kişidir.", "John C. Maxwell", "Liderlik Uzmanı", "Liderlik"),
        Quote(102, "Eğitim, dünyayı değiştirmek için kullanabileceğiniz en güçlü silahtır.", "Nelson Mandela", "Güney Afrika Devlet Başkanı", "Liderlik"),
        Quote(103, "Eğitimin pahalı olduğunu düşünüyorsanız, cehaletin bedelini hesaplayın.", "Sokrates", "Antik Yunan Filozofu", "Felsefe"),
        Quote(104, "Siz kendinize inanın, başkaları da size inanacaktır.", "Johann Wolfgang von Goethe", "Alman Şair, Yazar", "Felsefe"),
        Quote(105, "Ağaç dikmek için en iyi zaman yirmi yıl önceydi. İkinci en iyi zaman şimdi.", "Çin Atasözü", "Çin", "Felsefe"),
        Quote(106, "Her çocuk bir sanatçıdır. Mesele büyüdüğünde de sanatçı kalabilmektir.", "Pablo Picasso", "Ressam", "Sanat"),
        Quote(107, "Hayal edebiliyorsan, yapabilirsin.", "Walt Disney", "Disney Kurucusu", "Sanat"),
        Quote(108, "Yetenek ucuzdur. Çaba pahalıdır.", "Stephen King", "Yazar", "Sanat"),
        Quote(109, "Şampiyon olduğunuzda değil, her gün antrenman yaptığınızda kazanırsınız.", "Floyd Mayweather", "Boksör", "Spor"),
        Quote(110, "Yenilgi, daha sert geri dönmek için bir fırsattır.", "Conor McGregor", "Dövüşçü", "Spor"),
        Quote(111, "Hayat, fırtınanın geçmesini beklemek değil, yağmurda dans etmeyi öğrenmektir.", "Vivian Greene", "Yazar", "Hayat"),
        Quote(112, "Şüphe, başarısızlıktan daha fazla hayali öldürür.", "Suzy Kassem", "Yazar", "Hayat"),
        Quote(113, "En iyi intikam, muazzam bir başarıdır.", "Frank Sinatra", "Şarkıcı, Aktör", "Hayat"),
        Quote(114, "Düşmek yenilgi değildir. Düşüp kalkmamak yenilgidir.", "Zig Ziglar", "Motivasyon Yazarı", "Hayat"),
        Quote(115, "Zor zamanlar güçlü insanları, güçlü insanlar iyi zamanları yaratır.", "G. Michael Hopf", "Yazar", "Hayat")
    )
    
    // PART 3: Quotes 116-200
    private val quotesPartThree = listOf(
        Quote(116, "Ordular! İlk hedefiniz Akdeniz'dir, ileri!", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(117, "Ekonomisi zayıf olan millet fakirlik ve düşkünlükten kurtulamaz.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(118, "Tarih yazmak, tarih yapmak kadar önemlidir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(119, "Özgürlük ve bağımsızlık benim karakterimdir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(120, "Kuvvet birdir ve o milletindir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(121, "Bilgi güçtür.", "Francis Bacon", "Filozof, Devlet Adamı", "Bilim"),
        Quote(122, "Gerçek bilgi, neyi bilmediğini bilmektir.", "Konfüçyüs", "Çinli Filozof", "Bilim"),
        Quote(123, "Gözlem, tüm bilgeliğin başlangıcıdır.", "Aristo", "Antik Yunan Filozofu", "Bilim"),
        Quote(124, "Her büyük buluş önce imkansız görünür.", "Arthur C. Clarke", "Bilim Kurgu Yazarı", "Bilim"),
        Quote(125, "Müşterilerinize o kadar iyi hizmet verin ki başkalarına anlatmadan duramayın.", "Walt Disney", "Disney Kurucusu", "Girişimcilik"),
        Quote(126, "Cesur olun. Başarısız olun. Sonra tekrar deneyin.", "Sheryl Sandberg", "Facebook COO", "Girişimcilik"),
        Quote(127, "Küçük düşünmek suçtur.", "Estée Lauder", "Kozmetik Markası Kurucusu", "Girişimcilik"),
        Quote(128, "Liderlik, sorumluluk almaktır, mazeret bulmak değil.", "Mitt Romney", "Politikacı, İş İnsanı", "Liderlik"),
        Quote(129, "İnsanları harekete geçirmek istiyorsan, onlara ilham ver.", "Simon Sinek", "Yazar, Motivasyon Konuşmacısı", "Liderlik"),
        Quote(130, "Değerli olan kolay elde edilmez.", "Spinoza", "Hollandalı Filozof", "Felsefe"),
        Quote(131, "Hayat, yaşadıklarından çok nasıl tepki verdiğinle ilgilidir.", "Epictetus", "Stoacı Filozof", "Felsefe"),
        Quote(132, "Mutluluğun sırrı, özgürlüktür. Özgürlüğün sırrı ise cesarettir.", "Thucydides", "Antik Yunan Tarihçisi", "Felsefe"),
        Quote(133, "Renk, ruhun dilidir.", "Wassily Kandinsky", "Ressam", "Sanat"),
        Quote(134, "Basitlik, karmaşıklığın ötesindeki sofistikeliktir.", "Leonardo da Vinci", "Sanatçı, Mucit", "Sanat"),
        Quote(135, "Zorluklardan güçlenerek çıkmak en iyi zaferdir.", "Rafael Nadal", "Tenisçi", "Spor"),
        Quote(136, "Kolay kazanılan zafer tatlı değildir.", "Cristiano Ronaldo", "Futbolcu", "Spor"),
        Quote(137, "Baskı altında elmas olursun ya da toz.", "Kobe Bryant", "Basketbolcu", "Spor"),
        Quote(138, "Her gün, hayatının en önemli günü gibi yaşa.", "Steve Jobs", "Apple Kurucusu", "Hayat"),
        Quote(139, "Mutluluk bir seçimdir.", "Shawn Achor", "Psikolog", "Hayat"),
        Quote(140, "Kendin ol, herkes alınmış.", "Oscar Wilde", "İrlandalı Yazar", "Hayat"),
        Quote(141, "Sonunda her şey iyi olacak, iyi değilse henüz son değildir.", "Oscar Wilde", "İrlandalı Yazar", "Hayat"),
        Quote(142, "Başarının sırrı başlamaktır.", "Mark Twain", "Amerikalı Yazar", "Hayat"),
        Quote(143, "Sınırlarını sorgula.", "Bruce Lee", "Dövüş Sanatçısı, Aktör", "Hayat"),
        Quote(144, "Su gibi ol: Engelleri aşar, duraksız akar.", "Bruce Lee", "Dövüş Sanatçısı, Aktör", "Felsefe"),
        Quote(145, "Sabır dağları aşar.", "Türk Atasözü", "Türkiye", "Felsefe")
    )
    
    // PART 4: Quotes 146-250 
    private val quotesPartFour = listOf(
        Quote(146, "Türk milleti çalışkandır, Türk milleti zekidir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(147, "Hürriyet olmayan bir memlekette ölüm ve çöküş vardır.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(148, "Büyük kararlar büyük insanlar tarafından verilir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(149, "Vatanın bütün ümidi ve geleceği size, genç nesillerin anlayış ve enerjisine bağlanmıştır.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(150, "Merak, bilgiden daha önemlidir.", "Albert Einstein", "Fizikçi, Nobel Ödüllü", "Bilim"),
        Quote(151, "Bilim, güzelliğin en yüksek formudur.", "Carl Sagan", "Astrofizikçi", "Bilim"),
        Quote(152, "Şans, hazırlığın fırsatla buluştuğu andır.", "Louis Pasteur", "Mikrobiyolog", "Bilim"),
        Quote(153, "En iyi yatırım, kendinize yaptığınızdır.", "Warren Buffett", "Yatırımcı", "Girişimcilik"),
        Quote(154, "Paradan önce tutkuyu takip et.", "Tony Hsieh", "Zappos CEO", "Girişimcilik"),
        Quote(155, "Değişimi siz yaratmazsanız, değişim sizi yaratır.", "Jack Welch", "General Electric CEO", "Liderlik"),
        Quote(156, "Örnek olmak, başkalarını etkilemenin tek yoludur.", "Albert Schweitzer", "Doktor, Filozof", "Liderlik"),
        Quote(157, "Düşünce olmadan eylem kördür, eylem olmadan düşünce boştur.", "Immanuel Kant", "Alman Filozof", "Felsefe"),
        Quote(158, "Karanlığa küfretmektense bir mum yak.", "Konfüçyüs", "Çinli Filozof", "Felsefe"),
        Quote(159, "Yaşamak için ye, yemek için yaşama.", "Sokrates", "Antik Yunan Filozofu", "Felsefe"),
        Quote(160, "Yaratıcı olmak cesarettir.", "Henri Matisse", "Ressam", "Sanat"),
        Quote(161, "Her şampiyonun bir zamanlar pes etmeyi reddeden bir yarışmacı olduğunu unutma.", "Rocky Balboa", "Film Karakteri", "Spor"),
        Quote(162, "Limitler sadece kafanda.", "Michael Phelps", "Yüzücü", "Spor"),
        Quote(163, "Her antrenman bir fırsat, her an bir seçimdir.", "Tom Brady", "Amerikan Futbolcusu", "Spor"),
        Quote(164, "Rüyaların peşinden git.", "Paulo Coelho", "Brezilyalı Yazar", "Hayat"),
        Quote(165, "Açık zihin, açık kalp demektir.", "Dalai Lama", "Tibet Ruhani Lideri", "Felsefe"),
        Quote(166, "Her şey zihinle başlar.", "Buddha", "Ruhani Lider", "Felsefe"),
        Quote(167, "Zaman en değerli varlığınızdır, akıllıca harcayın.", "Benjamin Franklin", "Amerikan Kurucu Babası", "Hayat"),
        Quote(168, "Her son, yeni bir başlangıçtır.", "Seneca", "Roma Filozofu", "Felsefe"),
        Quote(169, "İyimserlik, başarının anahtarıdır.", "Helen Keller", "Yazar, Engelli Hakları Savunucusu", "Hayat"),
        Quote(170, "Harekete geç, sonuçlar gelir.", "Tony Robbins", "Motivasyon Koçu", "Hayat"),
        Quote(171, "Her zorluk, gizli bir fırsattır.", "Albert Einstein", "Fizikçi, Nobel Ödüllü", "Bilim"),
        Quote(172, "Gerçek bilgelik, bilmediğini bilmektir.", "Konfüçyüs", "Çinli Filozof", "Felsefe"),
        Quote(173, "Evrende değişmeyen tek şey değişimdir.", "Heraklitos", "Antik Yunan Filozofu", "Felsefe"),
        Quote(174, "En uzun gece bile biter.", "William Shakespeare", "İngiliz Yazar", "Hayat"),
        Quote(175, "Cesaret, korku yokluğu değildir.", "Nelson Mandela", "Güney Afrika Devlet Başkanı", "Liderlik")
    )
    
    // PART 5: Quotes 176-250
    private val quotesPartFive = listOf(
        Quote(176, "Milletimiz güçlü bir millet olmaya azmetmiştir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(177, "Her ilerlemenin ve kurtuluşun anası özgürlüktür.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(178, "Biz aklın, mantığın, ilmin rehberliğini kabul ediyoruz.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(179, "Bugünün bilimi, yarının teknolojisidir.", "Edward Teller", "Fizikçi", "Bilim"),
        Quote(180, "Keşfetmenin en iyi yolu denemektir.", "Alexander Fleming", "Bakteriyolog, Nobel Ödüllü", "Bilim"),
        Quote(181, "Harika şirketler harika ürünler yapar.", "Elon Musk", "Tesla & SpaceX CEO", "Girişimcilik"),
        Quote(182, "En mutsuz müşterileriniz, en büyük öğrenme kaynağınızdır.", "Bill Gates", "Microsoft Kurucusu", "Girişimcilik"),
        Quote(183, "Her şey liderlikle başlar ve biter.", "John Maxwell", "Liderlik Uzmanı", "Liderlik"),
        Quote(184, "Güven olmadan liderlik olmaz.", "Stephen Covey", "Yazar", "Liderlik"),
        Quote(185, "Acı çekmek insanın kaderidir. Acıdan anlam çıkarmak ise insanın görevidir.", "Viktor Frankl", "Psikiyatrist", "Felsefe"),
        Quote(186, "Yaşamak için limon verirse, limonata yapın.", "Elbert Hubbard", "Yazar", "Felsefe"),
        Quote(187, "Sanat, görünmezi görünür kılar.", "Paul Klee", "Ressam", "Sanat"),
        Quote(188, "Müzik, evrenin dilidir.", "Platon", "Antik Yunan Filozofu", "Sanat"),
        Quote(189, "Şampiyonlar, kimse izlemezken antrenman yapanlardır.", "Larry Bird", "Basketbolcu", "Spor"),
        Quote(190, "Mükemmellik bir hedef değil, bir süreçtir.", "Serena Williams", "Tenisçi", "Spor"),
        Quote(191, "Adım at, yol açılır.", "Paulo Coelho", "Brezilyalı Yazar", "Hayat"),
        Quote(192, "Sıkı çalış, sessiz kal, başarı gürültü yapsın.", "Frank Ocean", "Müzisyen", "Hayat"),
        Quote(193, "Mükemmeliyeti değil, ilerlemeyi hedefle.", "Anonim", "Atasözü", "Hayat"),
        Quote(194, "Kendi hikayeni yaz.", "Anonim", "Atasözü", "Hayat"),
        Quote(195, "En karanlık saatler, güneş doğmadan hemen öncekidir.", "Thomas Fuller", "Tarihçi", "Hayat"),
        Quote(196, "Hiçbir rüya küçük değildir.", "Anonim", "Atasözü", "Hayat"),
        Quote(197, "Gülümse, dünya gülümser.", "Thich Nhat Hanh", "Budist Üstat", "Hayat"),
        Quote(198, "Şimdi zamanı.", "Eckhart Tolle", "Ruhani Öğretmen", "Felsefe"),
        Quote(199, "Başarı bir yolculuktur, varış noktası değil.", "Ben Sweetland", "Yazar", "Hayat"),
        Quote(200, "Ve bu sadece başlangıç.", "Anonim", "Atasözü", "Hayat")
    )
    
    // PART 6: Quotes 201-270
    private val quotesPartSix = listOf(
        Quote(201, "Gençliğe hitabem ebediyen kalbinizde yaşasın.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(202, "Muhtaç olduğun kudret, damarlarındaki asil kanda mevcuttur.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(203, "Türk çocuğu, ecdadını tanıdıkça daha büyük işler yapmak için kendinde kuvvet bulacaktır.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(204, "Bu millet, bağımsızlık ve cumhuriyetinin nöbetini ehil ellere teslim etmeden gözlerini kapamayacaktır.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(205, "Hepiniz milletvekili olabilirsiniz, bakan olabilirsiniz, hatta cumhurbaşkanı olabilirsiniz. Fakat sanatkâr olamazsınız.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(206, "İnsan hareket ettikçe insanlaşır.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(207, "Akıl ve mantık her şeydir!", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(208, "Ben sporcunun zeki, çevik ve ahlaklısını severim.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(209, "Her şeye rağmen muhakkak bir ışığa doğru yürümekteyiz.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(210, "Tam bağımsızlık, ancak ekonomik bağımsızlıkla olur.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(211, "Dünyada her şey için, medeniyet için, hayat için, başarı için en hakiki mürşit ilimdir, fendir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(212, "Basın, milletin müşterek sesidir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(213, "Evrenin sırlarını çözmek, insanlığın kaderidir.", "Carl Sagan", "Astrofizikçi", "Bilim"),
        Quote(214, "İyi bir teori, yalnızca doğru olanı değil, yanlış olabilecekleri de ortaya koyar.", "Richard Feynman", "Fizikçi, Nobel Ödüllü", "Bilim"),
        Quote(215, "Bilim, şeyleri nasıl yapacağını değil, neden yapacağını öğretir.", "Jacques Cousteau", "Okyanus Kaşifi", "Bilim"),
        Quote(216, "Hayal gücünün sınırı, bilginin başladığı yerdir.", "Richard Feynman", "Fizikçi, Nobel Ödüllü", "Bilim"),
        Quote(217, "Doğanın büyüklüğü, onu ne kadar anlarsak o kadar artar.", "Richard Dawkins", "Evrimsel Biyolog", "Bilim"),
        Quote(218, "Atom parçalanabilir, ama insan ruhu parçalanamaz.", "Nelson Mandela", "Güney Afrika Devlet Başkanı", "Liderlik"),
        Quote(219, "Her başarı hikayesi, bir fedakarlık hikayesidir.", "Robin Sharma", "Yazar", "Girişimcilik"),
        Quote(220, "En büyük zafer, kendini yenmektir.", "Platon", "Antik Yunan Filozofu", "Felsefe"),
        Quote(221, "Öğrenmeye devam edin, çünkü yaşam öğretmeye devam ediyor.", "Anonim", "Atasözü", "Hayat"),
        Quote(222, "Yarını değiştirmek istiyorsanız bugün hareket edin.", "Dalai Lama", "Tibet Ruhani Lideri", "Hayat"),
        Quote(223, "Korku, hareketsizliğin bahanesidir.", "Paulo Coelho", "Brezilyalı Yazar", "Hayat"),
        Quote(224, "Basit şeyler en güzeldir.", "Leonardo da Vinci", "Sanatçı, Mucit", "Sanat"),
        Quote(225, "Azim, dehanın yarısıdır.", "Thomas Edison", "Mucit", "Bilim"),
        Quote(226, "Başarısızlık, başarıya giden yolun ta kendisidir.", "Thomas Edison", "Mucit", "Bilim"),
        Quote(227, "Her gün bir mucizedir.", "Ralph Waldo Emerson", "Amerikalı Yazar", "Hayat"),
        Quote(228, "Yürümeye başlamadan koşamazsın.", "Martin Luther King Jr.", "İnsan Hakları Lideri", "Liderlik"),
        Quote(229, "Bir rüyan varsa, onu koru.", "Chris Gardner", "Girişimci", "Girişimcilik"),
        Quote(230, "Dün geçti, yarın henüz gelmedi. Yalnızca bugün var.", "Madre Teresa", "Rahibe", "Felsefe"),
        Quote(231, "Tek gerçek sınırlama, kendi zihninizdeki sınırlamadır.", "Napoleon Hill", "Yazar", "Hayat"),
        Quote(232, "İmkansız diye bir şey yoktur, yalnızca imkanlar var.", "Anonim", "Atasözü", "Hayat"),
        Quote(233, "Yetenek kapıları açar, karakter açık tutar.", "John Wooden", "Basketbol Antrenörü", "Spor"),
        Quote(234, "Kazanmak alışkanlıktır. Ne yazık ki kaybetmek de.", "Vince Lombardi", "Amerikan Futbolu Antrenörü", "Spor"),
        Quote(235, "Antrenman zorlaşınca savaş kolaylaşır.", "Anonim", "Atasözü", "Spor"),
        Quote(236, "Hiçbir şey, kendi içinizde bir şey değişmeden değişmez.", "Deepak Chopra", "Yazar", "Felsefe"),
        Quote(237, "Düşünceler, kaderdir.", "Marcus Aurelius", "Roma İmparatoru", "Felsefe"),
        Quote(238, "Her büyük sanat eseri, yalnızlıktan doğar.", "Rainer Maria Rilke", "Alman Şair", "Sanat"),
        Quote(239, "Müzik, duyguların matematiğidir.", "Pythagoras", "Antik Yunan Matematikçisi", "Sanat"),
        Quote(240, "Her gün yeni bir başlangıçtır.", "Anonim", "Atasözü", "Hayat"),
        Quote(241, "Güçlü olmak tek seçeneğiniz olduğunda güçlü olursunuz.", "Bob Marley", "Müzisyen", "Hayat"),
        Quote(242, "Sadece hayal kurmak yetmez, onu gerçekleştirmelisin.", "Anonim", "Atasözü", "Hayat"),
        Quote(243, "İnsanın değeri, ne kadar kazandığıyla değil, ne kadar verdiğiyle ölçülür.", "Albert Einstein", "Fizikçi, Nobel Ödüllü", "Felsefe"),
        Quote(244, "Bir fikir, hayata geçirilene kadar bir fikirdir.", "Thomas Edison", "Mucit", "Girişimcilik"),
        Quote(245, "Küçük adımlar, büyük yolculukların başlangıcıdır.", "Anonim", "Atasözü", "Hayat"),
        Quote(246, "Disiplin, özgürlüğün köprüsüdür.", "Jim Rohn", "Motivasyon Konuşmacısı", "Hayat"),
        Quote(247, "En büyük servet sağlıktır.", "Virgil", "Roma Şairi", "Hayat"),
        Quote(248, "Pes etmemek, her şeydir.", "Winston Churchill", "İngiltere Başbakanı", "Liderlik"),
        Quote(249, "Tutkuyla başlayan her şey başarıyla biter.", "Napoleon Bonaparte", "Fransız İmparatoru", "Liderlik"),
        Quote(250, "Gerçek keşif yeni topraklar aramak değil, yeni gözlerle bakmaktır.", "Marcel Proust", "Fransız Yazar", "Felsefe"),
        Quote(251, "Her zorluk, yeni bir fırsat taşır.", "John Adams", "ABD Başkanı", "Liderlik"),
        Quote(252, "Korku sadece beş saniye sürer, cesaret ömür boyu.", "Anonim", "Atasözü", "Hayat"),
        Quote(253, "Hayat kısa, sanat uzun.", "Hippokrat", "Antik Yunan Hekimi", "Sanat"),
        Quote(254, "Tek bildiğim şey hiçbir şey bilmediğimdir, ve bu bile şüphelidir.", "Sokrates", "Antik Yunan Filozofu", "Felsefe"),
        Quote(255, "İnsan, düşündüğü şeydir.", "Ralph Waldo Emerson", "Amerikalı Yazar", "Felsefe"),
        Quote(256, "Yıldızlara ulaşamasan bile, aya konarsın.", "Les Brown", "Motivasyon Konuşmacısı", "Hayat"),
        Quote(257, "Kendine inan, her şey mümkün olur.", "Muhammad Ali", "Boksör", "Spor"),
        Quote(258, "Şampiyon, kimse izlemezken şut atan kişidir.", "Larry Bird", "Basketbolcu", "Spor"),
        Quote(259, "Başarı, tutkunun yan ürünüdür.", "Tony Robbins", "Motivasyon Koçu", "Girişimcilik"),
        Quote(260, "Hayatta başarısızlık yoktur, sadece geri bildirim vardır.", "Anonim", "Atasözü", "Hayat"),
        Quote(261, "Her gün bir sanat eseri gibi yaşa.", "Georgia O'Keeffe", "Ressam", "Sanat"),
        Quote(262, "Yaratıcı bir hayat için mükemmeliyetçilikten kurtulun.", "Pablo Picasso", "Ressam", "Sanat"),
        Quote(263, "Yaşadığınız her an bir hediyedir.", "Anonim", "Atasözü", "Hayat"),
        Quote(264, "Düşmek değil, kalkmamak utançtır.", "Konfüçyüs", "Çinli Filozof", "Felsefe"),
        Quote(265, "Önce kendinizi sevin, sonra her şey yerine oturur.", "Lucille Ball", "Aktris", "Hayat"),
        Quote(266, "Büyük hedefler, büyük inançla başlar.", "Anonim", "Atasözü", "Hayat"),
        Quote(267, "Kimse sizin izniniz olmadan sizi küçük hissettiremez.", "Eleanor Roosevelt", "ABD First Lady", "Liderlik"),
        Quote(268, "Güneşe doğru yüzünüzü çevirin, gölgeler arkanızda kalır.", "Maori Atasözü", "Yeni Zelanda", "Hayat"),
        Quote(269, "Her yeni gün, yepyeni bir sayfa.", "Anonim", "Atasözü", "Hayat"),
        Quote(270, "Hayat bir bisiklettir, dengede kalmak için hareket etmelisiniz.", "Albert Einstein", "Fizikçi, Nobel Ödüllü", "Hayat")
    )
    
    // PART 7: Quotes 271-340
    private val quotesPartSeven = listOf(
        Quote(271, "Fikirleri olan insanlar asla yalnız kalmaz.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(272, "Bir defa yükseldin mi, artık en yüksek yer senin olmalı.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(273, "Medeniyet yolunda yürümek ve başarı kazanmak hayat şartıdır.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(274, "Türk milletinin istidadı ve kesin kararı medeniyet yolunda durmadan, yılmadan ilerlemektir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(275, "Ümitvar olunuz, en şiddetli fırtınalar bile gelip geçicidir.", "Mevlana", "Sufi Şairi", "Felsefe"),
        Quote(276, "Bıraktığın yerde kalmak, geriye gitmek demektir.", "Mevlana", "Sufi Şairi", "Felsefe"),
        Quote(277, "Yarası olmayanın, yarayı ne bilir?", "Mevlana", "Sufi Şairi", "Felsefe"),
        Quote(278, "Aşk olmadan yapılan her iş yarım kalır.", "Mevlana", "Sufi Şairi", "Hayat"),
        Quote(279, "Her şey aşkla başlar.", "Mevlana", "Sufi Şairi", "Hayat"),
        Quote(280, "Ne kadar yükseğe çıkarsan çık, ayakların yere değsin.", "Yunus Emre", "Sufi Şairi", "Felsefe"),
        Quote(281, "Sevelim sevilelim, dünya kimseye kalmaz.", "Yunus Emre", "Sufi Şairi", "Hayat"),
        Quote(282, "İlim ilim bilmektir, ilim kendin bilmektir.", "Yunus Emre", "Sufi Şairi", "Felsefe"),
        Quote(283, "Söz ola kese savaşı, söz ola kestire başı.", "Yunus Emre", "Sufi Şairi", "Felsefe"),
        Quote(284, "Gelin tanış olalım, işi kolay kılalım.", "Yunus Emre", "Sufi Şairi", "Hayat"),
        Quote(285, "Bilim sadece gerçekleri değil, onların nedenlerini de açıklar.", "Galileo Galilei", "Astronom", "Bilim"),
        Quote(286, "Matematik, evrenin dilidir.", "Galileo Galilei", "Astronom", "Bilim"),
        Quote(287, "Doğa, matematiğin kitabında yazılmıştır.", "Galileo Galilei", "Astronom", "Bilim"),
        Quote(288, "Şüphe, bilgeliğin başlangıcıdır.", "Descartes", "Fransız Filozof", "Felsefe"),
        Quote(289, "Düşünüyorum, o halde varım.", "Descartes", "Fransız Filozof", "Felsefe"),
        Quote(290, "Her şeyi ölç, ölçülmeyeni ölçülebilir yap.", "Galileo Galilei", "Astronom", "Bilim"),
        Quote(291, "Başarının sırrı, herkesin baktığı yerde kimsenin görmediğini görmektir.", "Jeff Bezos", "Amazon Kurucusu", "Girişimcilik"),
        Quote(292, "Uzun vadeli düşün, kısa vadeli kayıplardan korkma.", "Jeff Bezos", "Amazon Kurucusu", "Girişimcilik"),
        Quote(293, "İşinizi sevin, müşterileriniz de sizi sevecek.", "Tony Hsieh", "Zappos CEO", "Girişimcilik"),
        Quote(294, "Kültür stratejiyi kahvaltıda yer.", "Peter Drucker", "Yönetim Bilimci", "Girişimcilik"),
        Quote(295, "En değerli varlığınız itibarınızdır.", "Warren Buffett", "Yatırımcı", "Girişimcilik"),
        Quote(296, "Korku ve açgözlülük piyasaları hareket ettirir.", "Warren Buffett", "Yatırımcı", "Girişimcilik"),
        Quote(297, "İnsanlar başkalarının onlar hakkında ne düşündüğünü fazla umursarlar.", "Mark Twain", "Amerikalı Yazar", "Hayat"),
        Quote(298, "Yirmi yıl sonra yapmadıklarınızdan pişman olursunuz.", "Mark Twain", "Amerikalı Yazar", "Hayat"),
        Quote(299, "Sıra dışı olmak istiyorsanız, sıradan olmayı bırakın.", "Anonim", "Atasözü", "Hayat"),
        Quote(300, "Başarı, hazırlık ve fırsatın buluşmasıdır.", "Oprah Winfrey", "Medya Patronu", "Girişimcilik"),
        Quote(301, "Her karanlık bulutun bir gümüş kenarı vardır.", "John Milton", "İngiliz Şair", "Hayat"),
        Quote(302, "Yarın için en iyi hazırlık bugün en iyisini yapmaktır.", "H. Jackson Brown Jr.", "Yazar", "Hayat"),
        Quote(303, "Basit olmak zordur ama buna değer.", "Jack Welch", "General Electric CEO", "Girişimcilik"),
        Quote(304, "Her lider bir öğretmendir.", "Eleanor Roosevelt", "ABD First Lady", "Liderlik"),
        Quote(305, "Liderlik hizmet etmektir.", "Robert K. Greenleaf", "Yönetim Düşünürü", "Liderlik"),
        Quote(306, "Güçlü olmak yetmez, güçlü kalmak gerekir.", "Anonim", "Atasözü", "Hayat"),
        Quote(307, "Her profesyonel bir zamanlar amatördü.", "Helen Hayes", "Aktris", "Hayat"),
        Quote(308, "Fırsat, çalışanlara gülümser.", "Anonim", "Atasözü", "Hayat"),
        Quote(309, "Kendi yolunu yarat.", "Don Ward", "Komedyen", "Hayat"),
        Quote(310, "Günler uzun, yıllar kısa.", "Gretchen Rubin", "Yazar", "Hayat"),
        Quote(311, "Her şey bir nedenle olur.", "Aristoteles", "Antik Yunan Filozofu", "Felsefe"),
        Quote(312, "Mutluluğu içeride ara, dışarıda değil.", "Epictetus", "Stoacı Filozof", "Felsefe"),
        Quote(313, "Sahip olduğun her şeyi verirsen, gerçekten istediğini alırsın.", "Rumi", "Sufi Şairi", "Felsefe"),
        Quote(314, "Kalp görür, göz görmez bakar.", "Mevlana", "Sufi Şairi", "Felsefe"),
        Quote(315, "Gerçek güzellik içeriden gelir.", "Anonim", "Atasözü", "Hayat"),
        Quote(316, "Bir şeyleri değiştirmek için değişmelisin.", "Jim Rohn", "Motivasyon Konuşmacısı", "Hayat"),
        Quote(317, "Minnettar olmak mutluluğun anahtarıdır.", "Cicero", "Roma Filozofu", "Felsefe"),
        Quote(318, "Sade yaşa ki özgürce yaşa.", "Epicurus", "Antik Yunan Filozofu", "Felsefe"),
        Quote(319, "Her insan kendi talihinin mimarıdır.", "Sallustius", "Roma Tarihçisi", "Hayat"),
        Quote(320, "Bugün yarından daha iyidir.", "Türk Atasözü", "Türkiye", "Hayat"),
        Quote(321, "Sabır acı, meyvesi tatlı.", "Aristoteles", "Antik Yunan Filozofu", "Felsefe"),
        Quote(322, "Bir damla mürekkep bir milyon insanı düşündürebilir.", "Lord Byron", "İngiliz Şair", "Sanat"),
        Quote(323, "Dans, bedenin şiiridir.", "Martha Graham", "Dansçı", "Sanat"),
        Quote(324, "Resim sessiz şiir, şiir konuşan resimdir.", "Simonides", "Antik Yunan Şairi", "Sanat"),
        Quote(325, "Müzik ruhun ilaçtır.", "Platon", "Antik Yunan Filozofu", "Sanat"),
        Quote(326, "Sanat, hayatın yarattığı şeydir.", "Gustav Klimt", "Avusturyalı Ressam", "Sanat"),
        Quote(327, "Sıkı antrenman kolay maç getirir.", "Anonim", "Atasözü", "Spor"),
        Quote(328, "Motive ol ya da yenik düş.", "Pele", "Futbolcu", "Spor"),
        Quote(329, "Her maç bir savaştır.", "Cristiano Ronaldo", "Futbolcu", "Spor"),
        Quote(330, "Zafer asla pes etmeyinceye kadar uzaktır.", "Anonim", "Atasözü", "Spor"),
        Quote(331, "Kazanmak her şey değildir ama kazanmak için çalışmak her şeydir.", "Vince Lombardi", "Amerikan Futbolu Antrenörü", "Spor"),
        Quote(332, "Spora adanan hayat, yaşanmış hayattır.", "Anonim", "Atasözü", "Spor"),
        Quote(333, "Her düşüşten bir şey öğren.", "Mary Lou Retton", "Jimnastikçi", "Spor"),
        Quote(334, "Zihin güçlüyse beden dayanır.", "Anonim", "Atasözü", "Spor"),
        Quote(335, "Spor, dürüstlüğin en somut halidir.", "Anonim", "Atasözü", "Spor"),
        Quote(336, "Hareketsizlik paslanmadan beterdir.", "Benjamin Franklin", "Amerikan Kurucu Babası", "Spor"),
        Quote(337, "Vücudunuz tapınağınızdır, ona iyi davranın.", "Astrid Alauda", "Yazar", "Hayat"),
        Quote(338, "Sağlık en büyük hediyedir.", "Buddha", "Ruhani Lider", "Hayat"),
        Quote(339, "Hareket ettikçe güçlenirsin.", "Anonim", "Atasözü", "Spor"),
        Quote(340, "Beden eğitim, zihin eğitiminin temelidir.", "Thomas Jefferson", "ABD Başkanı", "Spor")
    )
    
    // PART 8: Quotes 341-405
    private val quotesPartEight = listOf(
        Quote(341, "Mendil çıkardığım gün bana söz söylemek hakkını kazanırsınız.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(342, "Düşmanları yenmek şerefli bir zaferdir fakat asıl şerefli zafer, kendini yenmektir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(343, "Türk! Kendi olmaktan, milletine güvenmekten vazgeçme.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(344, "Zaman ne kadar çabuk geçerse geçsin, biz daha çabuk geliriz.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(345, "Milletlerin tarihindeki başarı veya başarısızlık yalnız ekonomik sebeplerle açıklanabilir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(346, "Herkes kendi işini kendisi görmelidir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(347, "Bilim tek yol göstericidir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(348, "Zamanın bir değil, bin namusu vardır.", "Hz. Mevlana", "Sufi Şairi", "Felsefe"),
        Quote(349, "Bu dünya bir rüyadır, uyan.", "Hz. Mevlana", "Sufi Şairi", "Felsefe"),
        Quote(350, "Dilini tut ki kalbini anlat.", "Hz. Mevlana", "Sufi Şairi", "Felsefe"),
        Quote(351, "Bilmediğin şeylerin cevabını arama.", "Hz. Mevlana", "Sufi Şairi", "Felsefe"),
        Quote(352, "İyi insan, başkalarının iyiliğini düşünen insandır.", "Konfüçyüs", "Çinli Filozof", "Felsefe"),
        Quote(353, "Dağa varmadan yola çıkmadığına hayıflanma.", "Çin Atasözü", "Çin", "Felsefe"),
        Quote(354, "Her insan kendi dünyasının merkezidir.", "Ralph Waldo Emerson", "Amerikalı Yazar", "Felsefe"),
        Quote(355, "Öğrenmek için yaşa, yaşamak için öğren.", "Anonim", "Atasözü", "Hayat"),
        Quote(356, "Her gün yeni bir fırsattır.", "Anonim", "Atasözü", "Hayat"),
        Quote(357, "Herkes kendi yolunu çizer.", "Anonim", "Atasözü", "Hayat"),
        Quote(358, "Yaşamak bir sanattır.", "Oscar Wilde", "İrlandalı Yazar", "Sanat"),
        Quote(359, "Az şey çok şey değerindedir.", "Mies van der Rohe", "Mimar", "Sanat"),
        Quote(360, "Güzel olan her şey değerlidir.", "Oscar Wilde", "İrlandalı Yazar", "Sanat"),
        Quote(361, "Sanat, tabiattan bir parçadır.", "Claude Monet", "Ressam", "Sanat"),
        Quote(362, "Her tablo bir hikaye anlatır.", "Frida Kahlo", "Ressam", "Sanat"),
        Quote(363, "Emek başarının annesidir.", "Vince Lombardi", "Amerikan Futbolu Antrenörü", "Spor"),
        Quote(364, "Başarı yolculuğu tek başına değildir.", "Kareem Abdul-Jabbar", "Basketbolcu", "Spor"),
        Quote(365, "Ter dökmeden kazanılmaz.", "Anonim", "Atasözü", "Spor"),
        Quote(366, "Mücadele eden kaybetmez.", "Anonim", "Atasözü", "Spor"),
        Quote(367, "Her gol yeni bir hikaye.", "Lionel Messi", "Futbolcu", "Spor"),
        Quote(368, "Azimle karınca bile dağı deler.", "Türk Atasözü", "Türkiye", "Hayat"),
        Quote(369, "Damlaya damlaya göl olur.", "Türk Atasözü", "Türkiye", "Hayat"),
        Quote(370, "Gülü seven dikenine katlanır.", "Türk Atasözü", "Türkiye", "Hayat"),
        Quote(371, "Bugünün işini yarına bırakma.", "Türk Atasözü", "Türkiye", "Hayat"),
        Quote(372, "Her şeyin başı sağlık.", "Türk Atasözü", "Türkiye", "Hayat"),
        Quote(373, "Bilgi güç, güç özgürlük.", "Francis Bacon", "Filozof, Devlet Adamı", "Bilim"),
        Quote(374, "Sorgulamadan öğrenmek imkansızdır.", "Socrates", "Antik Yunan Filozofu", "Bilim"),
        Quote(375, "Neden sorusu, bilimin başlangıcıdır.", "Anonim", "Atasözü", "Bilim"),
        Quote(376, "Her gözlem bir buluşa götürebilir.", "Isaac Newton", "Fizikçi, Matematikçi", "Bilim"),
        Quote(377, "Evren düşünce gücüyle keşfedilir.", "Albert Einstein", "Fizikçi, Nobel Ödüllü", "Bilim"),
        Quote(378, "Her çaba bir ödül getirir.", "Napoleon Hill", "Yazar", "Girişimcilik"),
        Quote(379, "Fikir üretmek kolay, uygulamak zor.", "Reid Hoffman", "LinkedIn Kurucusu", "Girişimcilik"),
        Quote(380, "Büyümek için risk al.", "Richard Branson", "Virgin Kurucusu", "Girişimcilik"),
        Quote(381, "Her yenilik bir devrimdir.", "Steve Jobs", "Apple Kurucusu", "Girişimcilik"),
        Quote(382, "Vizyon olmadan strateji olmaz.", "Peter Drucker", "Yönetim Bilimci", "Liderlik"),
        Quote(383, "Liderler dinlemesini bilir.", "Jim Rohn", "Motivasyon Konuşmacısı", "Liderlik"),
        Quote(384, "Güçlü lider güçlü takım demektir.", "Phil Jackson", "Basketbol Antrenörü", "Liderlik"),
        Quote(385, "Liderlik empatiyle başlar.", "Daniel Goleman", "Psikolog", "Liderlik"),
        Quote(386, "Her karar bir adım.", "Anonim", "Atasözü", "Liderlik"),
        Quote(387, "Yöneticiler işleri doğru yapar, liderler doğru işleri yapar.", "Peter Drucker", "Yönetim Bilimci", "Liderlik"),
        Quote(388, "Sorumluluk almak büyümenin başlangıcıdır.", "Anonim", "Atasözü", "Liderlik"),
        Quote(389, "Eleştiri olmadan gelişim olmaz.", "Ken Blanchard", "Yönetim Danışmanı", "Liderlik"),
        Quote(390, "İletişim liderliğin kalbidir.", "James Humes", "Yazar", "Liderlik"),
        Quote(391, "Başkalarına ilham vermek liderliğin özüdür.", "John Maxwell", "Liderlik Uzmanı", "Liderlik"),
        Quote(392, "Her plan, onu uygulayacak kişi kadar iyidir.", "Anonim", "Atasözü", "Liderlik"),
        Quote(393, "Her sorun bir öğretmendir.", "Anonim", "Atasözü", "Hayat"),
        Quote(394, "Hatalardan ders al.", "Henry Ford", "Ford Motor Kurucusu", "Hayat"),
        Quote(395, "Geçmişe takılma, geleceğe bak.", "Anonim", "Atasözü", "Hayat"),
        Quote(396, "Olumlu düşün, olumlu yaşa.", "Norman Vincent Peale", "Yazar", "Hayat"),
        Quote(397, "Sevgi her kapıyı açar.", "Madre Teresa", "Rahibe", "Hayat"),
        Quote(398, "Umut son nefeste bile yaşar.", "Anonim", "Atasözü", "Hayat"),
        Quote(399, "Kararlılık başarının sırrıdır.", "Anonim", "Atasözü", "Hayat"),
        Quote(400, "Her yeni gün sıfırdan başlamak için bir fırsattır.", "Anonim", "Atasözü", "Hayat"),
        Quote(401, "Yaşam cesaret gerektirir.", "Maya Angelou", "Amerikalı Yazar", "Hayat"),
        Quote(402, "Güneş her gün doğar.", "Anonim", "Atasözü", "Hayat"),
        Quote(403, "Bugün varı yokmuş gibi yaşa.", "Marcus Aurelius", "Roma İmparatoru", "Felsefe"),
        Quote(404, "Her nefes bir hediye.", "Thich Nhat Hanh", "Budist Üstat", "Hayat"),
        Quote(405, "Dünya sana gülümser, sen de gülümse.", "Anonim", "Atasözü", "Hayat")
    )
    
    // PART 9: Quotes 406-470
    private val quotesPartNine = listOf(
        Quote(406, "Yükselmeye devam et.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(407, "Biz her şeyi halkımız için yaparız.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(408, "Birlik ve beraberlik içinde olmak lazımdır.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(409, "İleri milletler seviyesine ulaşmalıyız.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(410, "Memleket mukaddes bir emanettir.", "Mustafa Kemal Atatürk", "Türkiye Cumhuriyeti Kurucusu", "Atatürk"),
        Quote(411, "Güç birlikten doğar.", "Anonim", "Atasözü", "Liderlik"),
        Quote(412, "Birlikte başarmak kolaydır.", "Henry Ford", "Ford Motor Kurucusu", "Girişimcilik"),
        Quote(413, "Takım çalışması rüyaları gerçekleştirir.", "Anonim", "Atasözü", "Liderlik"),
        Quote(414, "Bir elin nesi var, iki elin sesi var.", "Türk Atasözü", "Türkiye", "Hayat"),
        Quote(415, "Paylaşmak çoğalmaktır.", "Anonim", "Atasözü", "Hayat"),
        Quote(416, "İyilik yap denize at.", "Türk Atasözü", "Türkiye", "Hayat"),
        Quote(417, "Komşusu aç iken tok yatan bizden değildir.", "Hz. Muhammed", "İslam Peygamberi", "Felsefe"),
        Quote(418, "İnsanların en hayırlısı insanlara faydalı olandır.", "Hz. Muhammed", "İslam Peygamberi", "Felsefe"),
        Quote(419, "Güzel söz sadakadır.", "Hz. Muhammed", "İslam Peygamberi", "Felsefe"),
        Quote(420, "İlim Çin'de bile olsa gidip öğreniniz.", "Hz. Muhammed", "İslam Peygamberi", "Bilim"),
        Quote(421, "Akıl en büyük hazinedir.", "Hz. Ali", "Halife", "Felsefe"),
        Quote(422, "Sabır zaferin anahtarıdır.", "Hz. Ali", "Halife", "Felsefe"),
        Quote(423, "Bilge olan dinler.", "Hz. Ali", "Halife", "Felsefe"),
        Quote(424, "En büyük cihad nefisle mücadeledir.", "Hz. Ali", "Halife", "Felsefe"),
        Quote(425, "Az konuş, çok düşün.", "Hz. Ali", "Halife", "Felsefe"),
        Quote(426, "Dost eleştirir, düşman över.", "Hz. Ali", "Halife", "Felsefe"),
        Quote(427, "Zor günler güçlü insanlar yetiştirir.", "Anonim", "Atasözü", "Hayat"),
        Quote(428, "Cesur ol, korkma.", "Nelson Mandela", "Güney Afrika Devlet Başkanı", "Liderlik"),
        Quote(429, "Öğrenmenin yaşı yoktur.", "Anonim", "Atasözü", "Bilim"),
        Quote(430, "Her gün bir şey öğren.", "Anonim", "Atasözü", "Bilim"),
        Quote(431, "Okumak aydınlanmaktır.", "Anonim", "Atasözü", "Bilim"),
        Quote(432, "Kitap en iyi dosttur.", "Anonim", "Atasözü", "Bilim"),
        Quote(433, "Eğitim en güçlü silahtır.", "Nelson Mandela", "Güney Afrika Devlet Başkanı", "Bilim"),
        Quote(434, "Öğretmen bir mumun ışığıdır.", "Anonim", "Atasözü", "Bilim"),
        Quote(435, "Her keşif merakla başlar.", "Albert Einstein", "Fizikçi, Nobel Ödüllü", "Bilim"),
        Quote(436, "Düşünce eylemden önce gelir.", "Anonim", "Atasözü", "Felsefe"),
        Quote(437, "Bugün yarının hazırlığıdır.", "Anonim", "Atasözü", "Hayat"),
        Quote(438, "Düşler gerçek olabilir.", "Walt Disney", "Disney Kurucusu", "Hayat"),
        Quote(439, "Her bitiş yeni bir başlangıçtır.", "Anonim", "Atasözü", "Hayat"),
        Quote(440, "Geleceği yaratmak senin elindedir.", "Abraham Lincoln", "ABD Başkanı", "Liderlik"),
        Quote(441, "Kendine inanç, dünyayı değiştirir.", "Mahatma Gandhi", "Hindistan Bağımsızlık Lideri", "Liderlik"),
        Quote(442, "Her adım önemlidir.", "Anonim", "Atasözü", "Hayat"),
        Quote(443, "Şükretmek mutluluğa açılan kapıdır.", "Anonim", "Atasözü", "Hayat"),
        Quote(444, "Huzur içten gelir.", "Buddha", "Ruhani Lider", "Felsefe"),
        Quote(445, "Az olsun öz olsun.", "Türk Atasözü", "Türkiye", "Hayat"),
        Quote(446, "İyi niyet başarının yarısıdır.", "Anonim", "Atasözü", "Hayat"),
        Quote(447, "Küçük şeylerde büyük mutluluk vardır.", "Anonim", "Atasözü", "Hayat"),
        Quote(448, "Gülmek iyi gelir.", "Anonim", "Atasözü", "Hayat"),
        Quote(449, "Her zorluk bir derstir.", "Anonim", "Atasözü", "Hayat"),
        Quote(450, "Başarı içten gelir.", "Anonim", "Atasözü", "Hayat"),
        Quote(451, "Her insan değerlidir.", "Madre Teresa", "Rahibe", "Hayat"),
        Quote(452, "Saygı kazanılır.", "Anonim", "Atasözü", "Hayat"),
        Quote(453, "Tutku her şeydir.", "Anonim", "Atasözü", "Girişimcilik"),
        Quote(454, "Yeniliğe açık ol.", "Steve Jobs", "Apple Kurucusu", "Girişimcilik"),
        Quote(455, "Fark yaratmak için farklı ol.", "Anonim", "Atasözü", "Girişimcilik"),
        Quote(456, "Kalite her zaman önemlidir.", "Steve Jobs", "Apple Kurucusu", "Girişimcilik"),
        Quote(457, "Müşteri her zaman haklıdır.", "Harry Gordon Selfridge", "Perakende Öncüsü", "Girişimcilik"),
        Quote(458, "Her iş aşkla yapılmalı.", "Anonim", "Atasözü", "Girişimcilik"),
        Quote(459, "Kazanmak için oyna.", "Anonim", "Atasözü", "Spor"),
        Quote(460, "Her maç son maç gibi oyna.", "Anonim", "Atasözü", "Spor"),
        Quote(461, "Takım ruhu her şeydir.", "Michael Jordan", "Basketbolcu", "Spor"),
        Quote(462, "Zorluklara meydan oku.", "Anonim", "Atasözü", "Spor"),
        Quote(463, "Spor karakter inşa eder.", "Heywood Broun", "Gazeteci", "Spor"),
        Quote(464, "Her düşüşten kalk.", "Anonim", "Atasözü", "Spor"),
        Quote(465, "Yaratıcılık sınır tanımaz.", "Anonim", "Atasözü", "Sanat"),
        Quote(466, "Her renk bir duygu anlatır.", "Wassily Kandinsky", "Ressam", "Sanat"),
        Quote(467, "Sanat özgürlüktür.", "Pablo Picasso", "Ressam", "Sanat"),
        Quote(468, "Müzik ruhu yükseltir.", "Ludwig van Beethoven", "Besteci", "Sanat"),
        Quote(469, "Şiir kelimelerin dansıdır.", "Anonim", "Atasözü", "Sanat"),
        Quote(470, "Ve yolculuk devam ediyor...", "Anonim", "Atasözü", "Hayat")
    )
}

