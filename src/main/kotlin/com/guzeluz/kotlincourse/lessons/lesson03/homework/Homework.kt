package com.guzeluz.kotlincourse.lessons.lesson03.homework

//1. Название мероприятия
    val nameOfHackathon: String = "Space Hackathon"

//2. Дата проведения
    var dateOfHackathon: String = "04 October, 2025"

//3. Место проведения
    var placeOfHackathon: String = "Appenzeller Str 111, 81475, Germany, Earth"

//4. Подробный бюджет мероприятия, включая расходы на оборудование, кейтеринг и другие операционные расходы.
    private val detailedBudgetForEvent: String = "A detailed budget for the event, including equipment, catering and other operating expenses."

//5. Количество участников
    var numberOfParticipants: Int = 150
        set(value) {
            require(value >= 0) { "The number of participants cannot be negative!" }
            field = value
        }

//6. Длительность хакатона
    val durationInDays: Int = 5

//7. Контактная информация и условия соглашений с поставщиками пищи, оборудования и других услуг.
    private var contactInformation: String = "Contact information and terms of agreements with suppliers of food, equipment and other services."

//8. Текущее состояние хакатона (статус)
    var stateOfHackathon: String = "PLANNED"
        private set

//9. Список спонсоров
    val listOfSponsors: String = "Ilon Mask, Bill Gates, Mark Zuckerberg, Jeff Bezos"

//10. Бюджет
    private val totalBudgetForEvent: Long = 1_000_000_000

//11. Текущий уровень доступа к интернету
    val currentAccessForInternet: String by lazy {
        "Allowed"
    }

//12. Информация о транспортировке оборудования, распределении ресурсов и координации между различными командами поддержки.
    lateinit var supportInfo: String

//13. Количество команд
    var numberOfTeams: Int = 50

//14. Перечень задач
    private val listOfTasks: String = "Launch a rocket with a dog into space, contact other planets"

//15. План эвакуации
    val evacuationPlan: String = "Launch rescue rockets"

//16. Список доступного оборудования (всё, что выделено для использования на мероприятии)
    val listOfEquipment: String = "100 rockets, 50 dogs, 1 rabbit"

//17. Список свободного оборудования (всё, что можно взять прямо сейчас и что не занято другими участниками)
    var listOfFreeEquipment: String = "54 rockets, 34 dogs, 1 rabbit"

//18. График питания участников (зависит от поставщика питания, определяемого за неделю до начала)
    lateinit var mealSchedule: String

//19. План мероприятий на случай сбоев
    val backupPlan: String = "Backup plan for failures"

//20. Список экспертов и жюри
    val listOfExpertsAndJury: String = "Experts, Jury members"

//21. Политика конфиденциальности
    val privacyPolicy: String = "Privacy policy for participants and visitors"

//22. Приватные отзывы (фидбэк) участников и зрителей для анализа проблем.
    private var feedbackList: String = ""

//23. Текущая температура в помещении
    var currentTemperature: Double = 22.5

//24. Данные мониторинга и анализ производительности сетевого оборудования и интернет-соединения для целей отладки своих приложений командами
    private var networkMonitoringData: String = "Network stats for debugging"

//25. Регулятор скорости интернета
    var internetSpeedLimit: Int = 100 // Mbps

//26. Уровень освещения
    var lightLevel: Int = 80 // in %

//27. Лог событий
    var eventLog: String = ""

//28. Возможность получения медицинской помощи прямо на мероприятии (да/нет)
    val medicalHelpAvailable: Boolean = true

//29. Планы и процедуры для обеспечения безопасности мероприятия, включая планы эвакуации и протоколы чрезвычайных ситуаций.
    val safetyPlan: String = "Security protocols, evacuation, emergency procedures"

//30. Регистрационный номер мероприятия
    val registrationNumber: String = "HACK-2025-001"

//31. Максимально допустимый уровень шума в помещении хакатона.
    val maxNoiseLevel: Int = 85 // dB

//32. Индикатор превышения уровня шума в помещениях (превышен или не превышен в данный момент)
    var isNoiseExceeded: Boolean = false

//33. План взаимодействия с прессой
    val pressPlan: String = "Press conference plan"

//34. Детальная публичная информация о проектах каждой команды, сбор данных включает в себя компиляцию кода и сбор статистики прогона автоматизированных проверок.
    var projectsPublicInfo: String = "Compiled project data"

//35. Статус получения всех необходимых разрешений для проведения мероприятия
    private var isAllPermissionsGranted: Boolean = false

//36. Индикатор доступности специализированного оборудования в данный момент (например, специальному оборудованию)
    var isSpecialEquipmentAvailable: Boolean = false

//37. Список партнеров мероприятия
    val listOfPartners: String = "NASA, SpaceX, Google, Amazon"

//38. Отчет, включающий фотографии, видео и отзывы, генерируется и становится доступен после завершения мероприятия.
    val eventReport: String by lazy {
        "Photos, videos, feedback report"
    }
//39. Внутренние правила распределения призов
    private val prizeDistributionRules: String = "Internal prize rules"

//40. Список разыгрываемых призов
    val listOfPrizes: String = "1st: Rocket, 2nd: Dog, 3rd: Rabbit"

//41. Контактная информация экстренных служб, медицинского персонала и других важных служб, для внутреннего пользования.
    private val emergencyContacts: String = "Police 110, Fire 112, Ambulance 112"

//42. Особые условия для участников с ограниченными возможностями
    val accessibilityConditions: String = "Wheelchair access, assistance"

//43. Общее настроение участников (определяется опросами)
    var generalMood: String = "Excited"

//44. Подробный план хакатона, включающий время и содержание каждого сегмента, инициализируется непосредственно перед началом мероприятия, так как зависит от фактического состава команд и взятых в работу задач.
    lateinit var detailedHackathonPlan: String

//45. Имя знаменитого специального гостя, которое будет объявлено за день до мероприятия, но в момент инициализации неизвестно.
    lateinit var specialGuestName: String

//46. Максимальное количество людей, которое может вместить место проведения.
    val maxCapacity: Int = 1000

//47. Количество часов, отведенное каждой команде для работы над проектом.
    val hoursPerProject: Int = 40


/*
Перед тем, как объявить переменную, задай ей несколько вопросов:

1. Как тебя назвать, чтобы спустя месяц или год после того как забыл о чём этот код, всё ещё было понятно что ты хранишь? Дай название.
2. Должны ли тебя видеть прохожие или ты будешь хранить секретные данные? Объявляй как private если данные секретные.
3. Есть ли острая необходимость изменять твои данные? Объяви как val если необходимости нет, иначе var.
4. Есть ли возможность задать значение при инициализации? Если на момент старта значение не может быть известно, объяви как lateinit var. Иначе проинициализируй стартовым значением.
5. Сколько памяти и процессорного времени ты затратишь если я тебя сразу проинициализирую? А может быть инициализация будет динамическая и важно это сделать в подходящий момент? Если инициализация потребует дополнительных ресурсов или момент во времени важен, то используй val by lazy
6. Нужно ли делать валидацию значения при записи в изменяемую переменную? Если да, используй сеттер для var переменной.
7. Нужно ли изменять получаемое из переменной значение? Если да, используй геттер для val или var переменной.
8. Нужно ли запретить доступ на запись значения извне при сохранении возможности читать извне? Если да, то используй сеттер с модификатором private.
 */