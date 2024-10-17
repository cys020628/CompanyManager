package com.lion.view

import com.lion.controller.Controller
import com.lion.repository.EmployeeRepository
import com.lion.util.MainMenuNumber
import com.lion.util.ProgramState
import com.lion.util.Util
import jdk.jfr.StackTrace
import java.util.InputMismatchException
import java.util.Scanner

class ShowMainMenuView(val controller: Controller) : ViewClass() {
    override fun show() {
        // 데이터 가져오기
        loadData()
        // 메뉴 표시
        showMainMenu()
        // 입력 번호 받기
        val inputNumber = inputNumber()
        // 받은 번호로 메뉴 분기
        setProgramState(inputNumber)
    }

    // 메인메뉴 레이아웃 표시
    private fun showMainMenu() {
        println()
        println("메뉴를 선택해주세요")
        println("1. 부서 추가")
        println("2. 부서 삭제(속한 그룹의 직원도 삭제)")
        println("3. 직원 정보 입력")
        println("4. 전체 직원 정보 조회")
        println("5. 직원 이름 검색(정보 조회)")
        println("6. 직원 정보 삭제(이름 검색)")
        println("7. 부서별 직원 목록 조회")
        println("8. 프로그램 종료")
        print("메뉴 입력 :")
    }

    // 이동할 메뉴 번호 받기
    private fun inputNumber(): Int {
        val scanner = Scanner(System.`in`)
        while (true) {
            try {
                val inputNumber = scanner.nextInt()
                return inputNumber
            } catch (i: InputMismatchException) {
                println("잘못된 입력입니다. 숫자를 입력해주세요.")
                print("메뉴 입력 :")
                scanner.nextLine()
            } catch (e: Exception) {
                println("알 수 없는 오류가 발생했습니다. 다시 입력해주세요.")
                print("메뉴 입력 :")
                scanner.nextLine()
            }
        }
    }

    // 선택한 숫자에 따라 분기
    private fun setProgramState(inputNumber: Int) {
        when (inputNumber) {
            // 부서 추가
            MainMenuNumber.MAIN_MENU_INPUT_TYPE.number -> {
                controller.programState = ProgramState.STATE_INPUT_TYPE
            }
            // 부서 삭제
            MainMenuNumber.MAIN_MENU_DELETE_TYPE.number -> {
                controller.programState = ProgramState.STATE_DELETE_TYPE
            }
            // 직원 정보 입력
            MainMenuNumber.MAIN_MENU_INPUT_EMPLOYEE_INFO.number -> {
                controller.programState = ProgramState.STATE_INPUT_EMPLOYEE_INFO
            }
            // 전체 직원 정보 조회
            MainMenuNumber.MAIN_MENU_SHOW_ALL_EMPLOYEE_INFO.number -> {
                controller.programState = ProgramState.STATE_SHOW_ALL_EMPLOYEE_INFO
            }
            // 직원 이름 검색
            MainMenuNumber.MAIN_MENU_SEARCH_EMPLOYEE_INFO.number -> {
                controller.programState = ProgramState.STATE_SEARCH_EMPLOYEE_INFO
            }
            // 직원 정보 삭제
            MainMenuNumber.MAIN_MENU_DELETE_EMPLOYEE_INFO.number -> {
                controller.programState = ProgramState.STATE_DELETE_EMPLOYEE_INFO
            }
            // 부서별 직원 목록 조회
            MainMenuNumber.STATE_LIST_OF_EMPLOYEE_TYPE.number -> {
                controller.programState = ProgramState.STATE_LIST_OF_EMPLOYEE_TYPE
            }
            // 프로그램 종료
            MainMenuNumber.MAIN_MENU_EXIT_PROGRAM.number -> {
                controller.programState = ProgramState.STATE_EXIT_PROGRAM
            }
        }
    }

    private fun loadData() {
        Util.loadData(EmployeeRepository.getEmployeeList(), EmployeeRepository.getEmployeeTypeList())
    }
}