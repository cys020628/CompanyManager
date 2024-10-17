package com.lion.controller

import com.lion.util.ProgramState
import com.lion.util.ProgramState.STATE_INPUT_EMPLOYEE_INFO
import com.lion.view.*

class Controller {

    // 프로그램의 상태값을 담을 변수
    var programState: ProgramState = ProgramState.STATE_SHOW_MAIN_MENU

    // 각 상태별로 출력하는 객체를 담을 변수
    lateinit var viewClass: ViewClass

    // 각 상태별로 분기

    fun runController() {
        val isRunning = true //계속해서 돌려주기 위한 변수

        while (isRunning) {
            viewClass = when (programState) {
                // 메인메뉴
                ProgramState.STATE_SHOW_MAIN_MENU -> {
                    ShowMainMenuView(this)
                }
                // 부서 추가
                ProgramState.STATE_INPUT_TYPE ->  {
                    InputEmployeeTypeView(this)
                }
                // 부서 삭제
                ProgramState.STATE_DELETE_TYPE -> {
                    DeleteEmployeeTypeView(this)
                }
                // 직원 정보 추가
                STATE_INPUT_EMPLOYEE_INFO -> {
                    InputEmployeeInfoView(this)
                }
                // 전체 직원 정보 조회
                ProgramState.STATE_SHOW_ALL_EMPLOYEE_INFO -> {
                    ShowAllEmployeeInfoView(this)
                }
                // 직원 정보 검색
                ProgramState.STATE_SEARCH_EMPLOYEE_INFO -> {
                    SearchEmployeeInfoView(this)
                }
                // 직원 정보 삭제
                ProgramState.STATE_DELETE_EMPLOYEE_INFO -> {
                    DeleteEmployeeInfoView(this)
                }
                // 부서별 직원 목록 조회
                ProgramState.STATE_LIST_OF_EMPLOYEE_TYPE -> {
                    ListOfEmployeeType(this)
                }
                // 프로그램 종료
                ProgramState.STATE_EXIT_PROGRAM -> {
                    ExitProgramView(this)
                }
            }
            viewClass.show()
        }
    }
}