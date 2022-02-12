# task-manager

Конфигурация бд прописывается в `/src/main/resources/application.properties`.

Так же нужно указать зависимости для драйверов в **pom.xml**
(там уже есть зависимости для mysql, PostgreSQL и H2).

___________
### HTTP методы:
**GET** `("/tasks")`

Возвращает список задач отсортированных по дате модификации (от болле новых к более старым)

Пример response:

    [
        {
            "id": 1,
            "name": "one",
            "description": "one description",
            "lastUpdate": "2022-02-11 23:30:49.678"
        },
        {
            "id": 2,
            "name": "two",
            "description": "two description",
            "lastUpdate": "2022-02-11 23:22:37.937"
        }
    ]

**GET** `("/tasks/{id}")`

Возвращает задачу с указанным id
Если задача найдена в response возвращается описание задачи в формате json

Пример response:

    {
        "id": 1,
        "name": "one",
        "description": "one description",
        "lastUpdate": "2022-02-11 23:30:49.678"
    }

**POST** `("/tasks")`

В теле запроса передается объект в формате json с полями id, name, description.
Если задача с таким id уже есть в базе, она обновляется

**PUT** `("/tasks")`

В теле запроса передается объект в формате json с полями id, name, description
если объекта с таким id в базе нет, возвращается ошибка

Пример request:

    {
        "id": 1,
        "name": "some name",
        "description": "some description"
    }







