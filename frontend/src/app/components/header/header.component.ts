import { Component } from '@angular/core';
import { BlogsService } from 'src/app/services/blogs.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  
  searchKey:string= ''

constructor(private _blogsService: BlogsService){
}

setSearchValue(){
  this._blogsService.UpdateSearchValue(this.searchKey);
}

}
