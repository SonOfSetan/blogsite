import { Component } from '@angular/core';
import { BlogsService } from 'src/app/services/blogs.service';

@Component({
  selector: 'app-paginator',
  templateUrl: './paginator.component.html',
  styleUrls: ['./paginator.component.scss']
})
export class PaginatorComponent {

  limit: number = 9;
  show: boolean = true;
  constructor(private _blogsService: BlogsService){}

  setLimit(){
    this.limit+= 9;
    this._blogsService.updateLimit(this.limit);
    if(this.limit>30){
        this.show = false;
    }
  }
}
