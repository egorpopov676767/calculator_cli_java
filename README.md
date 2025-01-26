Автор: Попов Егор Евгеньевич

Индивидуальный проект "Calculator CLI" в рамках курса "Проектная деятельность"

Режимы работы программы:
- запуск с аргументами: выполняет команду и завершает работу
- запуск без аргументов: принимает команды и выводит результаты в интерактивном режиме

Ввод данных:
- аргументы запуска или поток ввода (консоль по умолчанию)

Вывод данных:
- поток вывода (консоль по умолчанию)

Список доступных команд:
- add [v1] [v2] ... [vn]: суммирует числа
- sub [v1] [v2] ... [vn]: поочерёдно вычитает из первого числа все последующие
- mul [v1] [v2] ... [vn]: перемножает числа
- div [v1] [v2] ... [vn]: поочерёдно делит первое число на все последующие
- pow [value] [p]: возводит число в степень
- log [a] [b]: логарифм числа b по основанию a
- sqrt [value]: квадратный корень числа
- help: выводит информацию о доступных командах

Примеры команд:
- add 1 2 5 7.89  ->  15.89
- pow 3 4.5  ->  140.29611541307906
- div 90 7 5 0  ->  Ошибка: деление на ноль
