package org.sterzhen.ypmtool.data.entities;

public enum TaskStatus {

    NEW("Новая"),
    ANALYSIS("Анализ"),
    DEVELOPMENT("Разработка"),
    REVIEW("Ревью"),
    TESTING("Тестирование"),
    DONE("Выполнена"),
    CANCELLED("Отменена"),
    HOLD("Приостановлена"),
    DELETED("Удалена");

    private final String label;


    TaskStatus(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
