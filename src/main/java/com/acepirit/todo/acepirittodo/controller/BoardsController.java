package com.acepirit.todo.acepirittodo.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acepirit.todo.acepirittodo.entity.Boards;
import com.acepirit.todo.acepirittodo.entity.Task;
import com.acepirit.todo.acepirittodo.service.BoardsService;
import com.acepirit.todo.acepirittodo.service.TaskService;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;



@Controller
@RequestMapping("/board")
public class BoardsController {
	
	@Autowired
	private BoardsService boardService;
	@Autowired
	private TaskService taskService;
	
//	@Autowired
//	public BoardsController(BoardsService boardServices) {
//	
//		boardService = boardServices;
//	}
//
//	
//	public BoardsController(TaskService taskservice) {
//		taskService = taskservice;
//	}

	@GetMapping("/listboards")
	public String listBoards(Model theModel) {
		List<Boards> theBoards  = boardService.findAll();
		theModel.addAttribute("boards",theBoards);
		return "board/boards";
		
		
	}
	@GetMapping("/addboard")
	public String addBoard(Model theModel) {
		Boards newboard = new Boards();
		theModel.addAttribute("board",newboard);
		return "board/addboard";
		
	}
	@PostMapping("/saveBoard")
	public String saveBoard(@ModelAttribute("board") Boards board ) {
		board.setCreated_at(new Date(System.currentTimeMillis()));
		boardService.save(board);
		return "redirect:/board/listboards";
		
	}
	@GetMapping("/listtask")
	public String listTask(@RequestParam("boardid") int boardid,Model theModel) {
		//List<Task> taks = taskService.findAllByBoards(boardService.findById(boardid));
		List<Task> tododtask = taskService.findAllByBoardsANDType(boardService.findById(boardid), "TODO");

		List<Task> inprogresstask = taskService.findAllByBoardsANDType(boardService.findById(boardid), "DOING");

		List<Task> completedtask = taskService.findAllByBoardsANDType(boardService.findById(boardid), "COMPLETED");
		
		System.out.println("Board id"+tododtask);
		
		theModel.addAttribute("tasks",tododtask);
		theModel.addAttribute("inprogresstask",inprogresstask);
		theModel.addAttribute("completedtask",completedtask);
		
		theModel.addAttribute("boardId",boardid);
		return "task/listtask";
	}
	@GetMapping("/addTaskForm")
	public String addTask(@RequestParam("boardid") int boardid,Model theModel) {
		Task mtask = new Task();
		Boards mboard = boardService.findById(boardid);
		mtask.setBoards(mboard);
		theModel.addAttribute("task",mtask);
		return "task/addtask";
	}
	@PostMapping("/saveTask")
	public String saveTask(@ModelAttribute("task") Task mtask){
		mtask.setType("TODO");
		mtask.setCreated_at(new Date(System.currentTimeMillis()));
	//	int boardids = mtask.getBoardId();
		
		//Boards mboards = boardService.findById(boardids);
		//mtask.setBoards(mboards);
		System.out.println("Getting saved boards"+mtask.getBoards());
		
		
		taskService.save(mtask);
		return "redirect:/board/listtask?boardid="+mtask.getBoards().getId();
		
		}
	
	@GetMapping("/delete")
	public String deleteBoards(@RequestParam("boardid") int boardid) {
		boardService.deleteById(boardid);
		return "redirect:/board/listboards";
	}
	@GetMapping("/editBoard")
	public String editBoards(@RequestParam("boardid") int boardid,Model theModel) {
		Boards board = boardService.findById(boardid);
		theModel.addAttribute("board",board);
		return "board/addboard";
		
	}
}
