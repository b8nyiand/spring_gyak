import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListItemsComponent } from './list-items/list-items.component';

const routes: Routes = [

  { path: '', redirectTo: '/todo-list', pathMatch: 'full' },
  {
    path: 'todo-list',
    component: ListItemsComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

  

 }
