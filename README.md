# Lab5
## Laboratory work No. 5 on programming Saint Petersburg State University of Information Technologies, Mechanics and Optics
Реализовать консольное приложение, которое реализует управление коллекцией объектов в интерактивном режиме. В коллекции необходимо хранить объекты класса City, описание которого приведено ниже.

### Разработанная программа должна удовлетворять следующим требованиям:

1. Класс, коллекцией экземпляров которого управляет программа, должен реализовывать сортировку по умолчанию.
2. Все требования к полям класса (указанные в виде комментариев) должны быть выполнены.
3. Для хранения необходимо использовать коллекцию типа java.util.Vector
4. При запуске приложения коллекция должна автоматически заполняться значениями из файла.
5. Имя файла должно передаваться программе с помощью: аргумент командной строки.
6. Данные должны храниться в файле в формате csv
7. Чтение данных из файла необходимо реализовать с помощью класса java.io.BufferedInputStream
8. Запись данных в файл необходимо реализовать с помощью класса java.io.BufferedOutputStream
9. Все классы в программе должны быть задокументированы в формате javadoc.
10. Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, отсутсвие прав доступа к файлу и т.п.).

### В интерактивном режиме программа должна поддерживать выполнение следующих команд:

help : вывести справку по доступным командам<br/>
info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)<br/>
show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении<br/>
add {element} : добавить новый элемент в коллекцию<br/>
update id {element} : обновить значение элемента коллекции, id которого равен заданному<br/>
remove_by_id id : удалить элемент из коллекции по его id<br/>
clear : очистить коллекцию<br/>
save : сохранить коллекцию в файл<br/>
execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.<br/>
exit : завершить программу (без сохранения в файл)<br/>
remove_first : удалить первый элемент из коллекции<br/>
add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции<br/>
remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный<br/>
min_by_standard_of_living : вывести любой объект из коллекции, значение поля standardOfLiving которого является минимальным<br/>
group_counting_by_id : сгруппировать элементы коллекции по значению поля id, вывести количество элементов в каждой группе<br/>
filter_by_meters_above_sea_level metersAboveSeaLevel : вывести элементы, значение поля metersAboveSeaLevel которых равно заданному<br/>
### Формат ввода команд:

* Все аргументы команды, являющиеся стандартными типами данных (примитивные типы, классы-оболочки, String, классы для хранения дат), должны вводиться в той же строке, что и имя команды.
* Все составные типы данных (объекты классов, хранящиеся в коллекции) должны вводиться по одному полю в строку.
* При вводе составных типов данных пользователю должно показываться приглашение к вводу, содержащее имя поля (например, "Введите дату рождения:")
* Если поле является enum'ом, то вводится имя одной из его констант (при этом список констант должен быть предварительно выведен).
* При некорректном пользовательском вводе (введена строка, не являющаяся именем константы в enum'е; введена строка вместо числа; введённое число не входит в указанные границы и т.п.) должно быть показано сообщение об ошибке и предложено повторить ввод поля.
* Для ввода значений null использовать пустую строку.
* Поля с комментарием "Значение этого поля должно генерироваться автоматически" не должны вводиться пользователем вручную при добавлении.
* Описание хранимых в коллекции классов:

        public class City {
            private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
            private String name; //Поле не может быть null, Строка не может быть пустой
            private Coordinates coordinates; //Поле не может быть null
            private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
            private int area; //Значение поля должно быть больше 0
            private long population; //Значение поля должно быть больше 0
            private Float metersAboveSeaLevel;
            private Integer carCode; //Значение поля должно быть больше 0, Максимальное значение поля: 1000, Поле не может быть null
            private Government government; //Поле не может быть null
            private StandardOfLiving standardOfLiving; //Поле не может быть null
            private Human governor; //Поле может быть null
        }
        public class Coordinates {
            private Long x; //Поле не может быть null
            private double y;
        }
        public class Human {
            private long age; //Значение поля должно быть больше 0
        }
        public enum Government {
            CORPORATOCRACY,
            OLIGARCHY,
            ETHNOCRACY;
        }
        public enum StandardOfLiving {
            ULTRA_HIGH,
            VERY_HIGH,
            LOW,
            ULTRA_LOW,
            NIGHTMARE;
        }
