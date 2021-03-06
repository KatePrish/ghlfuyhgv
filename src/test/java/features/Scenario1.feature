#language: ru
  Функционал: проверка наличия номера счета 2-го порядка

    Предыстория:
      Дано открыт браузер, переход по ссылке
      И осуществлен переход на эф "Вход в систему"
      Когда пользователь заполняет поле "Имя пользователя" значением "sua_all"
      И пользователь заполняет поле "Пароль" значением "Q1w2e3r4"
      И пользователь нажимает кнопку "Войти"
      Тогда осуществлен переход на эф "Выбор финансовой организации"
      Когда пользователь выбирает финансовую организацию "10"
      И пользователь нажимает кнопку "Выбрать"
      Тогда открывается страница с логотипом "Агентство по страхованию вкладов"
      Тогда открывается страница с финансовой организацией "10"

    @11118
    Сценарий: проверка наличия номера счета 2-го порядка "202"

      И пользователь нажимает кнопку с выпадающим списком "Настройка"
      И пользователь выбирает пункт "Справочники"
      Тогда открывается страница с таблицей "Справочники"
      И пользователь нажимает ссылку "План счетов  по КО" в столбце "Краткое наименование"
      И пользователь нажимает кнопку "Поиск" в верхней панели таблицы
      То открывается модальное окно "Поиск..."
      Когда пользователь выбирает пункт "Номер счёта 2-го порядка" в выпадающем списке "ID Плана Счетов"
      И пользователь выбирает пункт "начинается с" в выпадающем списке "содержит"
      И пользователь заполняет поле значением "202"
      И пользователь нажимает кнопку "Найти"
      Тогда отображается "Номер счета 2-го порядка" содержащий "202"
      И пользователь нажимает кнопку "Права  Все"
      И пользователь нажимает кнопку "Выход" в контекстном меню
      И браузер закрыт