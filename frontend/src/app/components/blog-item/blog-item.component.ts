import { Component, Input, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Blog } from 'src/app/interfaces/blog';
import { BlogsService } from 'src/app/services/blogs.service';

@Component({
  selector: 'app-blog-item',
  templateUrl: './blog-item.component.html',
  styleUrls: ['./blog-item.component.scss']
})
export class BlogItemComponent{
  @Input() blog?: Blog;

  constructor(){
  }


}
