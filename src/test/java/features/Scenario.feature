#language: ru
Функционал: аутентификация в систему

  Предыстория:
    Дано открыт браузер, переход по ссылке
    И осуществлен переход на эф "Вход в систему"

  @11111
  Структура сценария: аутентификация с валидными данными
    Когда пользователь вводит в поле "Имя пользователя" значение "<логин>"
    И пользователь вводит в поле "Пароль" значение "<пароль>"
    И пользователь нажимает кнопку "Войти"
    Тогда осуществлен переход на эф "Выбор финансовой организации"
    Тогда пользователь выбирает финансовую организацию "INC"
    И пользователь нажимает кнопочку "Выбрать"
    Тогда открывается страница с логотипом "Агентство по страхованию вкладов"
    Тогда открывается страница с финансовой организацией "INC"
    И пользователь нажимает кнопку "Права  Все"
    И пользователь нажимает кнопку "Выход"
    И браузер закрыт

    Примеры:
    |   логин      |   пароль     |
    |   sua_all    |   Q1w2e3r4   |

  @11112
  Сценарий: : аутентификация с невалидными данными
    Когда пользователь вводит в поля "Имя пользователя" и "Пароль" значения
      |   sua_a89l    |   Q1w2e3r1   |
    И пользователь нажимает кнопку "Войти"
    Тогда открывается страница с сообщением "Неверное имя пользователя или пароль."
    И браузер закрыт