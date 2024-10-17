package com.lion.view

import com.lion.controller.Controller
import com.lion.repository.EmployeeRepository
import com.lion.util.ProgramState
import java.util.*

class InputEmployeeInfoView(val controller: Controller) : ViewClass() {
    override fun show() {

        // 등록되어 있는 부서가 있는지 확인
        if (checkIsExistDepartment()) {
            // 부서가 등록되어 있는 경우
            // 입력할 부서를 선택하게 한다.
            showEmployeeType()
            val inputType = inputDeleteEmployeeType()
            // 입력한 부서가 현재 존재하는지 체크
            if (checkIsExistEmployeeType(inputType)) {
                // 입력한 부서가 존재한다면
                // 정보를 입력받고 등록 진행
                inputEmployeeInfo(inputType)
            } else {
                // 입력한 부서가 존재하지 않는다면
                println("입력하신 부서는 등록되어 있지 않은 부서입니다.")
            }
        } else {
            // 부서가 등록되어 있지 않은경우
            println("현재 등록되어 있는 부서가 없습니다.\n먼저 부서를 등록해주세요.")
        }
        // 화면 상태를 메인메뉴로 변경
        controller.programState = ProgramState.STATE_SHOW_MAIN_MENU
    }

    // 등록되어 있는 부서가 있는지 확인
    private fun checkIsExistDepartment(): Boolean {
        return EmployeeRepository.getAllEmployeeType().isNotEmpty()
    }

    // 현재 등록된 부서를 반환하는 함수
    private fun showEmployeeType() {
        println("현재 등록된 부서 ${EmployeeRepository.getAllEmployeeType()}")
    }

    // 부서를 입력받는 기능
    private fun inputDeleteEmployeeType(): String {
        val scanner = Scanner(System.`in`)
        print("등록할 부서의 이름을 입력해주세요 : ")
        val inputName = scanner.next()
        return inputName
    }

    // 입력받은 부서가 현재 존재하는지 검사하는 함수
    private fun checkIsExistEmployeeType(inputType: String): Boolean {
        return EmployeeRepository.checkEmployeeTypeIs(inputType)
    }

    // 직원 정보를 입력받는 기능
    private fun inputEmployeeInfo(employeeType: String) {
        val scanner = Scanner(System.`in`)
        var name: String
        var age: Int
        var rank: String

        while (true) {
            try {
                print("이름을 입력해주세요 : ")
                name = scanner.next()
                break
            } catch (e: Exception) {
                println("잘못된 입력입니다. 다시 시도해주세요.")
                scanner.nextLine()
            }
        }

        while (true) {
            try {
                print("나이를 입력해주세요 : ")
                age = scanner.nextInt()
                break
            } catch (e: Exception) {
                println("잘못된 입력입니다. 숫자를 입력해주세요.")
                scanner.nextLine()
            }
        }

        while (true) {
            try {
                print("직급을 입력해주세요 : ")
                rank = scanner.next()
                break
            } catch (e: Exception) {
                println("잘못된 입력입니다. 다시 시도해주세요.")
                scanner.nextLine() // 잘못된 입력을 비웁니다.
            }
        }
        // 직원 정보 입력
        EmployeeRepository.addEmployeeInfo(name, age, rank, employeeType)
    }
}