package com.lion.repository

import com.lion.data.EmployeeData
import com.lion.data.EmployeeTypeData
import com.lion.util.Values
import java.io.*

class EmployeeRepository {
    companion object {
        // 직원 정보를 저장하는 리스트
        private val employeeList = mutableListOf<EmployeeData>()

        // 부서 종류를 저장하는 리스트
        private val employeeTypeList = mutableListOf<EmployeeTypeData>()

        // 현재 등록된 직원의 전체 이름을 출력하는 함수
         fun showAllEmployee(): List<String> {
            val allEmpoyee = employeeList.map { it.employeeName }
            return allEmpoyee
        }

        // 현재 등록된 부서를 반환하는 함수
        fun getAllEmployeeType(): List<String> {
            return employeeTypeList.map { it.employeeType }
        }

        // 이미 등록된 부서인지 확인하는 함수
        fun checkDepartmentIsDuplication(inputType: String): Boolean {
            val isExist = employeeTypeList.find { it.employeeType == inputType }
            return isExist == null // 존재하지 않으면 중복되지 않으므로 true 반환
        }

        // 현재 등록된 직원이 있는지 확인하는 함수
        fun isExistEmployee(): Boolean {
            return employeeList.isNotEmpty()
        }

        // employeeList에서 해당 부서 종류를 찾아서 null 여부를 체크
        fun checkEmployeeTypeIs(type: String): Boolean {
            return employeeTypeList.find { it.employeeType == type } != null
        }

        // 부서를 추가하는 함수
        fun addEmployeeDepartment(type: String) {
            employeeTypeList.add(EmployeeTypeData(employeeType = type))
        }

        // 직원 정보를 추가하는 함수
        fun addEmployeeInfo(name: String, age: Int, rank: String, type: String) {
            // 해당 종류의 부서가 존재하는지 확인한다.
            val employeeType = employeeTypeList.find { it.employeeType == type }

            if (employeeType != null) {
                // 새로운 데이터 생성
                val newEmployee = EmployeeData(
                    employeeName = name,
                    employeeAge = age,
                    employeeRank = rank,
                    employeeType = employeeType
                )
                // 데이터 저장
                employeeList.add(newEmployee)
                println("$name 직원의 정보가 등록되었습니다.")
                println("부서 : $type")
                println("이름 : $name")
                println("나이 : ${age}살")
                println("직급 : ${rank}개")
            } else {
                println("해당 부서가 존재하지 않습니다. 먼저 부서를 추가해주세요.")
            }
        }

        // 직원 이름으로 검색하는 함수
        fun searchEmployeeName(inputName: String) {
            val findEmployee = employeeList.filter { it.employeeName == inputName }
            if (findEmployee.isNotEmpty()) {
                // 이름이 중복일수 있어 전체 출력
                findEmployee.forEach {
                    println("이름 : ${it.employeeName}")
                    println("나이 : ${it.employeeAge}살")
                    println("부서 : ${it.employeeType.employeeType}")
                    println("직급 : ${it.employeeRank}")
                }
            } else {
                println("이름이 $inputName 인 직원을 찾을 수 없습니다.")
            }
        }

        // 부서 삭제 함수(부서 내 직원들도 같이 삭제)
        fun deleteEmployeeType(type: String) {
            val isExistType = employeeTypeList.find { it.employeeType == type }
            // 부서가 존재하지는 확인
            if (isExistType != null) {
                // 직원 종류 삭제
                employeeTypeList.removeAll { it.employeeType == type }
                // 직원 정보 삭제
                employeeList.removeAll { it.employeeType.employeeType == type }
                println("$type 부서가 정상적으로 삭제되었습니다.")
            } else {
                println("해당 부서가 존재하지 않습니다.")
            }
        }

        // 직원 삭제 함수
        fun deleteEmployeeByName(inputName: String) {
            // 해당 이름의 직원이 존재하는지 확인
            val isExistEmployee = employeeList.find { it.employeeName == inputName }

            // 직원 삭제
            if (isExistEmployee != null) {
                // 직원 삭제
                employeeList.remove(isExistEmployee)
                println("$inputName 직원이 정상적으로 삭제되었습니다.")
            } else {
                // 직원이 존재하지 않을시 메세지 출력 후 false 반환
                println("해당 직원이 존재하지 않습니다.")
            }
        }

        // 전체 직원을 보여주는 함수
        fun showAllEmployeeInfo() {
            employeeTypeList.forEachIndexed { index, department ->
                employeeList.forEach { employee ->
                    if (employee.employeeType.employeeType == department.employeeType) {
                        println("부서: ${department.employeeType}")
                        println("이름 : ${employee.employeeName}")
                        println("나이 : ${employee.employeeAge}살")
                        println("직급 : ${employee.employeeRank}")
                        println("---------------------------")
                    }
                }
            }
        }

        fun showListOfEmployee(inputType: String) {
            // 해당 부서에 속한 직원들을 필터링
            val employeesInDepartment = employeeList.filter { employee ->
                employee.employeeType.employeeType == inputType }

            // 부서에 속한 직원이 있는지 확인
            if (employeesInDepartment.isNotEmpty()) {
                employeesInDepartment.forEach { employee ->
                    println("부서: ${employee.employeeType.employeeType}")
                    println("이름 : ${employee.employeeName}")
                    println("나이 : ${employee.employeeAge}살")
                    println("직급 : ${employee.employeeRank}")
                    println("---------------------------")
                }
            } else {
                println("입력하신 $inputType 부서는 존재하지 않습니다.")
            }
        }

        // employeeList 를 반환하는 함수
        fun getEmployeeList(): MutableList<EmployeeData> {
            return employeeList
        }

        // employeeTypeList를 반환하는 함수
        fun getEmployeeTypeList(): MutableList<EmployeeTypeData> {
            return employeeTypeList
        }
    }
}