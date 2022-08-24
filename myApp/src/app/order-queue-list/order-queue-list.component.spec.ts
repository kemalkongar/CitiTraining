import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderQueueListComponent } from './order-queue-list.component';

describe('OrderQueueListComponent', () => {
  let component: OrderQueueListComponent;
  let fixture: ComponentFixture<OrderQueueListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderQueueListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderQueueListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
