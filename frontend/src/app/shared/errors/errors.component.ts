import { Component, OnDestroy } from '@angular/core';
import { BlogsService } from 'src/app/services/blogs.service';
declare var $: any; 
@Component({
  selector: 'app-errors',
  templateUrl: './errors.component.html',
  styleUrls: ['./errors.component.scss']
})
export class ErrorsComponent implements OnDestroy{
subObject:any = {}; 

  constructor( private _blogsService: BlogsService){}

  reloadBlogs(){
  this.subObject['getBlogs'] = this._blogsService.getBlogs(9).subscribe({

    })
  }

ngOnDestroy(): void {
  Object.keys(this.subObject).forEach((key) => {
    this.subObject[key].unsubscribe();
  });
}
}