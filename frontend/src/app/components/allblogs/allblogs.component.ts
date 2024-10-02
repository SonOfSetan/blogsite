import { Component, OnDestroy, OnInit } from '@angular/core';
import { Blog } from 'src/app/interfaces/blog';
import { BlogsService } from 'src/app/services/blogs.service';

@Component({
  selector: 'app-allblogs',
  templateUrl: './allblogs.component.html',
  styleUrls: ['./allblogs.component.scss']
})
export class AllblogsComponent implements OnInit, OnDestroy{

  allBlogs: Blog[]= [];
  limit:number =9
  searchKey: string= '';
  errShow: boolean = false;
  subObject: any = {};
  constructor(private _blogsService: BlogsService){
  }

ngOnInit(): void {
 this.subObject['limit'] = this._blogsService.limit.subscribe((res)=>{
    this.limit = res;
    this.getAllBlogs();
   });

 this.subObject['searchValue'] = this._blogsService.searchValue.subscribe((res)=>{
    this.searchKey = res;
   });

}

getAllBlogs(){
this.subObject['allBlogs'] =  this._blogsService.getBlogs(this.limit).subscribe({
  next:(res)=>{
    this.allBlogs = res;
  },
  error:(err)=>{
    this.errShow = true;
    console.log(err);
  }
})
}


ngOnDestroy(): void {
  Object.keys(this.subObject).forEach((key) => {
    this.subObject[key].unsubscribe();
  });
}
}
