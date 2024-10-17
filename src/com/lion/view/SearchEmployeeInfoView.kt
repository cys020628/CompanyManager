package com.lion.view

import com.lion.controller.Controller
import com.lion.repository.EmployeeRepository
import com.lion.util.ProgramState
import java.util.*

class SearchEmployeeInfoView(val controller: Controller):ViewClass() {
    override fun show() {

        // 현재 등록되어있는 부서가 있는지 확인!
        if(checkIsExistDepartment()) {
            // 현재 등록되어있는 직원의 전체 이름을 출력한다.
            showAllEmployeeName()
            // 등록되어있는 부서가 있다면 이름을 입력받는다.
            val inputName = inputSearchEmployeeName()
            // 입력받은 값을 검색한다.
            searchEmployee(inputName)
        }else {
            // 부서가 등록되어있지 않다면
            println("정보가 등록되어 있지 않습니다. 먼저 정보를 입력해주세요.")
        }
        // 화면 상태를 메인메뉴로 변경
        controller.programState = ProgramState.STATE_SHOW_MAIN_MENU
    }

    // 현재 등록되어있는 부서가 있는지 확인
    private fun checkIsExistDepartment():Boolean {
        return EmployeeRepository.getAllEmployeeType().isNotEmpty()
    }

    // 검색할 직원의 이름을 받는다.
    // 삭제할 직원 정보의 이름을 입력받는 기능
    private fun inputSearchEmployeeName(): String {
        val scanner = Scanner(System.`in`)
        print("검색할 직원의 이름을 입력해주세요 : ")
        val inputName = scanner.next()
        return inputName
    }

    // 직원이 있는지 검색한다.
    private fun searchEmployee(inputName:String) {
        EmployeeRepository.searchEmployeeName(inputName)
    }

    // 전체 직원의 이름을 보여주는 함수
    private fun showAllEmployeeName() {
        println("전체 직원의 이름 : ${EmployeeRepository.showAllEmployee()}")
    }
}