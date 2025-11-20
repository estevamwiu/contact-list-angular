import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-new-groups-component',
  standalone: false,
  templateUrl: './new-groups-component.html',
  styleUrl: './new-groups-component.css',
})
export class NewGroupsComponent {
  
    groups: NewGroupsComponent [] = [];
    formGroupNewGroupForm: FormGroup;

      constructor (private formBuilder: FormBuilder) {
        this.formGroupNewGroupForm = this.formBuilder.group({
          name: [''],
          description: ['']
        });
      }

  save() {
    alert(this.formGroupNewGroupForm.value);
    this.groups.push(this.formGroupNewGroupForm.value);
}}

