package com.lion.view

import com.lion.controller.Controller
import com.lion.repository.EmployeeRepository
import com.lion.util.ProgramState
import java.util.*

class DeleteEmployeeInfoView(val controller: Controller):ViewClass() {
    override fun show() {
        // 현재 등록되어 직원이 있는지 확인
        if(checkIsExistEmployee()) {
            // 전체 직원의 이름을 보여준다.
            showAllEmployeeName()
            // 등록되어 있는 직원이 있다면 이름을 입력받는다.
            val inputName = inputDeleteEmployeeName()
            // 직원 정보 삭제 진행
            deleteEmployeeInfo(inputName)

        }else {
            // 등록되어 있는 직원이 없다면
            println("현재 등록되어 있는 직원이 없습니다.")
        }

        // 화면 상태를 메인메뉴로 변경
        controller.programState = ProgramState.STATE_SHOW_MAIN_MENU
    }

    // 등록되어 있는 직원이 있는지 확인
    private fun checkIsExistEmployee():Boolean {
        return EmployeeRepository.isExistEmployee()
    }

    // 삭제할 직원 정보의 이름을 입력받는 기능
    private fun inputDeleteEmployeeName(): String {
        val scanner = Scanner(System.`in`)
        print("삭제할 직원의 이름을 입력해주세요 : ")
        val inputName = scanner.next()
        return inputName
    }

    // 전체 직원의 이름을 보여주는 함수
    private fun showAllEmployeeName() {
        println("전체 직원의 이름 : ${EmployeeRepository.showAllEmployee()}")
    }

    // 직원 정보 삭제
    private fun deleteEmployeeInfo(inputName:String) {
        EmployeeRepository.deleteEmployeeByName(inputName)
    }
}