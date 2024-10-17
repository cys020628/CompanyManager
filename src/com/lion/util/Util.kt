package com.lion.util

import com.lion.data.EmployeeData
import com.lion.data.EmployeeTypeData
import java.io.*

class Util {
    companion object {

        private var isDataSW = true // loadData() 함수를 실행 후 한번만 실행해주기 위한 스위치

        // 데이터 저장 함수
        fun saveData(employeeList: MutableList<EmployeeData>, employeeTypeList: MutableList<EmployeeTypeData>) {
            val fileOutputStream = FileOutputStream(Values.fileName)
            val objectOutputStream = ObjectOutputStream(fileOutputStream)
            objectOutputStream.writeObject(employeeList)
            objectOutputStream.writeObject(employeeTypeList)
            objectOutputStream.flush()
            objectOutputStream.close()
            fileOutputStream.close()
        }

        // 데이터를 불러오는 함수
        fun loadData(employeeList: MutableList<EmployeeData>, employeeTypeList: MutableList<EmployeeTypeData>) {
            val file = File(Values.fileName)
            if (isDataSW) {
                if (!file.exists() || file.length() == 0.toLong()) {
                    // 파일이 존재하지 않거나 아무것도 작성되어 있지 않은경우 새로 생성
                    println("파일이 존재하지 않거나 비어 있습니다. 새로운 파일을 생성합니다.")
                    saveData(employeeList, employeeTypeList)
                } else {
                    try {
                        val fileInputStream = FileInputStream(Values.fileName)
                        val objectInputStream = ObjectInputStream(fileInputStream)
                        employeeList.clear()
                        employeeTypeList.clear()
                        employeeList.addAll(objectInputStream.readObject() as MutableList<EmployeeData>)
                        employeeTypeList.addAll(objectInputStream.readObject() as MutableList<EmployeeTypeData>)
                        objectInputStream.close()
                        fileInputStream.close()
                    } catch (e: EOFException) {
                        println("오류 : ${e.message}")
                    } catch (e: Exception) {
                        println("오류 : ${e.message}")
                    }
                    isDataSW = false
                }
            }
        }
    }
}