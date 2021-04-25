package edu.netcracker.tasks.task3.sql;

import java.util.Arrays;

/**
 * Класс, формирующий инструкцию SQL, которая вставляет строки в таблицу T_GroupSelected
 * <id_Student, firstName, lastName, id_Group> из таблицы
 * T_Student<id_Student, firstName, lastName, id_Group, dolgCount >
 * тех студентов, которые относятся к некоторой группе (строковый параметр)
 * и количество долгов (целочисленный параметр) которых превышает заданное значение.
 */
public class InstructionSQL {
    private final String[] tableColumns = {"id_Student", "firstName", "lastName", "id_Group"};
    private String sourceTableName = "T_Student";
    private String targetTableName = "T_GroupSelected";

    /**
     * Конструктор с параметрами.
     * @param sourceTableName название исходной таблицы (из которой выбираюся данные)
     * @param targetTableName название таблицы, в которую данные будут вставляться
     */
    public InstructionSQL(String sourceTableName, String targetTableName) {
        this.sourceTableName = sourceTableName;
        this.targetTableName = targetTableName;
    }

    /**
     * Конструктор без параметров.
     */
    public InstructionSQL() {
    }

    /**
     * Метод, возвращающий соответсвующий SQL-запрос в строковом представлении.
     * @param groupName название группы
     * @param dolgCount количество долгов
     * @return
     */
    public String getInstruction(String groupName, int dolgCount) {
        return String.format("INSERT INTO %s (%s)\n", targetTableName, getColumns()) +
                String.format("SELECT %s\nFROM %s\n", getColumns(), sourceTableName) +
                String.format("WHERE id_Group = '%s' AND %s.dolgCount > %d", groupName, sourceTableName, dolgCount);
    }

    /**
     * Метод, возвращающий значения tableColumns через запятую в виде строки.
     * @return строка со значениями tableColumns
     */
    private String getColumns() {
        return Arrays.toString(tableColumns).replaceAll("\\[|]", "");
    }

    public String getSourceTableName() {
        return sourceTableName;
    }

    public String getTargetTableName() {
        return targetTableName;
    }

    public void setSourceTableName(String sourceTableName) {
        this.sourceTableName = sourceTableName;
    }

    public void setTargetTableName(String targetTableName) {
        this.targetTableName = targetTableName;
    }
}
