package com.acepirit.todo.acepirittodo.controller;

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

import com.acepirit.todo.acepirittodo.entity.Comment;
import com.acepirit.todo.acepirittodo.entity.Subtask;
import com.acepirit.todo.acepirittodo.entity.Task;
import com.acepirit.todo.acepirittodo.service.CommentService;
import com.acepirit.todo.acepirittodo.service.SubtaskService;
import com.acepirit.todo.acepirittodo.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private SubtaskService subtaskService;
	
	@Autowired
	private CommentService commentService;

	@GetMapping("/taskdetails")
	public String taskDetail(@RequestParam("taskid") int taskid,Model theModel) {
		//finding dask detials by id
		Task task = taskService.findById(taskid);
		
		//listing all subtask list
		List<Subtask> subtasklist = subtaskService.findByTask(task);
		
		//listing all comment on the respected task
		List<Comment> allComment = commentService.findAllByTask(task);
		
		theModel.addAttribute("comments",allComment);
		theModel.addAttribute("taskdetail",task);
		theModel.addAttribute("subtasks",subtasklist);
		return "task/taskdetails";
	}
	
	//for subtask
	@GetMapping("/addsubtask")
	public String addSubtask(@RequestParam("taskid") int taskid,Model theModel) {
		Subtask msubtask = new Subtask();
		theModel.addAttribute("subtask",msubtask);
		Task task = taskService.findById(taskid);
		msubtask.setTask(task);
		//theModel.addAttribute("task",task);
		return "task/addsubtask";
	}
	
	@PostMapping("/saveSubTask")
	public String saveSubtask(@ModelAttribute("subtask") Subtask subtask) {
		
		subtask.setStatus("INCOMPLETE");
		System.out.println("subtask"+subtask.getTask());
		subtaskService.save(subtask);
		return "redirect:/task/taskdetails?taskid="+subtask.getTask().getId();
		
	}
	
	@GetMapping("/editSubTask")
	public String editSubtask(@RequestParam("subtaskid") int subtaskid,Model theModel) {
		Subtask subtask = subtaskService.findById(subtaskid);
		theModel.addAttribute("subtask",subtask);
		return "task/addsubtask";
		
	}
	
	@GetMapping("/deleteSubtask")
	public String deleteSubtask(@RequestParam("subtaskid") int subtaskid,@RequestParam("taskid") int taskid) {
		System.out.println("Taskid "+taskid+" Subtaskid"+subtaskid);
		subtaskService.deleteById(subtaskid);
		return "redirect:/task/taskdetails?taskid="+taskid;
	
	}
	@GetMapping("/ChangeSubtaskStatus")
	public String changSubtaskStatus(@RequestParam("subtaskid") int subtaskid,@RequestParam("taskid") int taskid) {
		Subtask subtask = subtaskService.findById(subtaskid);
		subtask.setStatus("COMPLETE");
		subtaskService.save(subtask);
		return "redirect:/task/taskdetails?taskid="+taskid;
	}
	
	
	
	
	
	
	@GetMapping("/showAddComment")
	public String showAddComment(@RequestParam("taskid") int taskid,Model theModel) {
		Task mtask = taskService.findById(taskid);
		
		Comment mcomment = new Comment();
		mcomment.setTask(mtask);
		
		theModel.addAttribute("comments",mcomment);
		
		return "comment/addcomment";
		
	}
	
	@PostMapping("/saveComment")
	public String saveComment(@ModelAttribute("comments") Comment comment) {
		comment.setCreated_at(new Date(System.currentTimeMillis()));
		System.out.println("comment"+comment.getComment());
		commentService.save(comment);
		
		return "redirect:/task/taskdetails?taskid="+comment.getTask().getId();
	}
	
	
	
}
