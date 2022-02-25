package com.codingdojo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.models.Lookify;
import com.codingdojo.services.LookifyService;

@Controller
public class LookifyController {
private final LookifyService lookifyService;
	
	public LookifyController( LookifyService lookifyService ) {
		this.lookifyService = lookifyService;
	}
	
	@RequestMapping( value="/", method=RequestMethod.GET )
	public String welcome() {
		return "welcome.jsp";
	}
	
	@RequestMapping( value="/dashboard", method=RequestMethod.GET )
	public String dashboard( Model model, @ModelAttribute("lookify") Lookify lookify ) {
		List<Lookify> lookifyList = lookifyService.selectAllFromLookify();
		model.addAttribute( "lookifyList", lookifyList );
		return "dashboard.jsp";
	}
	
	@RequestMapping( value="/songs/new", method=RequestMethod.GET )
	public String add( @ModelAttribute("lookify") Lookify lookify ) {
		return "add.jsp";
	}
	
	@RequestMapping( value="/songs/new", method=RequestMethod.POST )
	public String add_P( @Valid @ModelAttribute("lookify") Lookify lookify, BindingResult result, Model model ) {
		if( result.hasErrors() ) {
			List<Lookify> lookifyList = lookifyService.selectAllFromLookify();  // perfecto para editar
			model.addAttribute( "lookifyList", lookifyList );
			return "add.jsp";
		}
		lookifyService.insertIntoLookify(lookify);
		return "redirect:/dashboard";
	}
	
	//REVISAR
	@RequestMapping( value="/search/topTen", method=RequestMethod.GET )
	public String top( @Valid @ModelAttribute("lookify") Lookify lookify, BindingResult result, Model model ) {
		List<Lookify> lookifyList = lookifyService.selectAllFromLookify();
		ArrayList<Lookify> lookifyOrderList = new ArrayList<Lookify>();
		long order = 0;
		for( int i=0; i<lookifyList.size(); i++ ) {
			if( lookifyList.get(i).getRating() > order ) {
				lookifyOrderList.add(i, lookifyList.get(i));
			}
			else {
				lookifyOrderList.add(lookifyList.get(i));
			}
			order = lookifyList.get(i).getRating();
		}
		
		model.addAttribute( "lookifyOrderList", lookifyOrderList );
		return "top.jsp";
	}
	
	@RequestMapping( value="/songs/{id}", method=RequestMethod.GET )
	public String show(@PathVariable("id") int id, Model model ) {
		Lookify lookify = lookifyService.selectFromLookifyWhereId(id);
		model.addAttribute( "lookify", lookify );
		
		return "show.jsp";
    }
	
	//Search
	@RequestMapping( value="/search", method=RequestMethod.GET )
	public String search( Model model, @ModelAttribute("lookify") Lookify lookify ) {
		List<Lookify> lookifyList = lookifyService.selectFromLookifyWhereArtist(lookify.getArtist());
		model.addAttribute( "lookifyList", lookifyList );
		System.out.println(lookifyList.get(0).getTitle());
		return "search.jsp";
	}
	
	@RequestMapping( value = "/songs/delete/{id}", method = RequestMethod.DELETE )
	public String delete( @PathVariable("id") int id ) {
		lookifyService.deleteFromLookify(id);
		return "redirect:/dashboard";
	}
}
