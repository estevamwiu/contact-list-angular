import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-new-contact-component',
  standalone: false,
  templateUrl: './new-contact-component.html',
  styleUrl: './new-contact-component.css',
})
export class NewContactComponent {

    contacts: NewContactComponent [] = [];
    formGroupNewContactForm: FormGroup;

      constructor (private formBuilder: FormBuilder) {
        this.formGroupNewContactForm = this.formBuilder.group({
          name: [''],
          phone: [''],
          group: [''],
          email: [''],
          address: [''],
          notes: ['']
        });
      }

  save() {
    alert(this.formGroupNewContactForm.value);
    this.contacts.push(this.formGroupNewContactForm.value);
}}
