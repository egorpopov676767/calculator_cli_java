Индивидуальный проект "Calculator CLI" в рамках курса "Проектная деятельность"

Режимы работы программы:
- запуск с аргументами: выполняет команду и завершает работу
- запуск без аргументов: принимает команды и выводит результаты в интерактивном режиме

Ввод данных:
аргументы запуска или поток ввода (консоль по умолчанию)
Вывод данных:
поток вывода (консоль по умолчанию)

Список доступных команд:
- add [v1] [v2] ... [vn]: суммирует числа
- sub [v1] [v2] ... [vn]: вычитает из первого числа все последующие
- mul [v1] [v2] ... [vn]: перемножает числа
- div [v1] [v2] ... [vn]: делит на первое число все последующие
- pow [value] [p]: возводит число в степень
- sqrt [value]: квадратный корень числа
- help: выводит информацию о доступных командах

Примеры команды:
add 1 2 5 7.89  ->  15.89
pow 3 4  ->  81
